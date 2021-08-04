package com.zsy.basemodule.common.mvp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class BasePresenter<T : IView>(private var mView: T?) : IPresenter<T>,LifecycleObserver{

    /**
     * 关联View
     */
    override fun attach(view: T) {
        mView = view
        mView?.lifecycle?.addObserver(this)
    }

    /**
     * 与View解绑
     */
    override fun detach() {
        mView?.lifecycle?.removeObserver(this)
        mView = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(owner: LifecycleOwner){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(owner: LifecycleOwner){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner){
        detach()
    }
}