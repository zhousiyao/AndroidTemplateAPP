package com.zsy.basemodule.common.model

import com.zsy.basemodule.base.net.IResponse

class BaseResponse<T> : IResponse<T> {

    private var code = 0
    private var data: T? = null
    private var msg: String? = null

    fun setCode(code: Int) {
        this.code = code
    }

    fun setData(data: T) {
        this.data = data
    }

    fun setMsg(msg: String?) {
        this.msg = msg
    }

    override fun getData(): T? {
        return data
    }

    override fun getMsg(): String? {
        return msg
    }

    override fun getCode(): String? {
        return code.toString()
    }

    override fun isSuccess(): Boolean {
        return code == 200
    }

}