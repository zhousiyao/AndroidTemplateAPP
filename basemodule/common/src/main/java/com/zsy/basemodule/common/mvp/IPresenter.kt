package com.zsy.basemodule.common.mvp

interface IPresenter<V : IView> {
    fun attach(view: V)
    fun detach()
}
