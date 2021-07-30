package com.zsy.basemodule.base.net

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.zsy.basemodule.base.utils.ReflectUtil
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers.io

class ResponseTransformer<T> private constructor() : ObservableTransformer<IResponse<T>, T>, LifecycleObserver {

    private val compositeDisposable = CompositeDisposable()

    /**
     * 销毁Disposeable
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDstroy() {
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }

    //
    fun obtain(lifecycleOwner: LifecycleOwner):ResponseTransformer<T>{
        val responseTransformer = ResponseTransformer<T>()
        lifecycleOwner.lifecycle.addObserver(responseTransformer)

        return responseTransformer
    }

    override fun apply(upstream: Observable<IResponse<T>>): ObservableSource<T> {
        return upstream
                .doOnSubscribe { disposable -> compositeDisposable.add(disposable!!) } //统一绑定
                .onErrorResumeNext(Function { throwable -> // 出现异常统一处理 (非业务性的异常)
                    Observable.error(ApiException.handleException(throwable))})
                ?.flatMap<T>(object : Function<IResponse<T>, ObservableSource<T>> {
                    override fun apply(response: IResponse<T>): ObservableSource<T> {
                        if (response.isSuccess()) {
                            if (response.getData() != null) {
                                return Observable.just(response.getData())
                            } else {
                                // 业务请求可能成功了，但是data是NULL
                                // 通过反射手动创建data，这个data一般是没有实际用途
                                val clz = ReflectUtil.analysisClassInfo(response)
                                val `object` = clz.newInstance() as T
                                return Observable.just(`object`)
                            }
                        }
                        return Observable.error(ApiException(response.getCode(), response.getMsg()))
                    }

                })?.subscribeOn(io()) //指定事件产生的线程(请求的线程)
                ?.observeOn(AndroidSchedulers.mainThread())!! // 指定事件处理的线程 (响应的线程)

    }

}