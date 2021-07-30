package com.zsy.basemodule.base.net

/**
 * 定义响应基础接口
 */
interface IResponse<T> {

    fun getData(): T

    fun getMsg(): String

    fun getCode(): String

    fun isSuccess(): Boolean
}