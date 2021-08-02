package com.zsy.basemodule.base.net

import androidx.lifecycle.LifecycleOwner
import com.zsy.basemodule.base.net.ResponseTransformer.Companion.obtain
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/**
 * 统一请求的封装
 * （不一定要这么写，看个人爱好）
 */
object RequestModel {
    /**
     *
     * @param o 没啥说的，使用RxJava特性，做网络请求
     * @param lifecycleOwner 通过传过来的Owner与自定义的Observer产生关联，实现在onDestroy时销毁Disposable （防止Rxjava的内存泄漏）
     * @param callback
     * @param <T>
    </T> */
    fun <T> request(o: Observable<IResponse<T>>,
                    lifecycleOwner: LifecycleOwner,
                    callback: ICallback<T>) {
        val d: Disposable = o.compose(obtain(lifecycleOwner))
                .subscribe({ t -> callback.onSuccess(t) },
                        { throwable -> callback.onError(throwable!!) })
    }
}