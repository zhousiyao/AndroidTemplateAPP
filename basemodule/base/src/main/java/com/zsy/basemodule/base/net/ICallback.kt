package com.zsy.basemodule.base.net

interface ICallback<T> {

    fun onSuccess(data: T)

    fun onError(e: Throwable)

}