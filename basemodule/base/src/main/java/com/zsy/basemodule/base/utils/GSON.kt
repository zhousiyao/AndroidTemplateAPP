package com.zsy.basemodule.base.utils

import com.google.gson.Gson
import java.lang.ref.WeakReference

object GSON {
    private var instance: WeakReference<Gson?>? = null
    fun get(): Gson? {
        if (instance == null || instance!!.get() == null) {
            val gson = Gson()
            instance = WeakReference(gson)
        }
        return instance!!.get()
    }
}