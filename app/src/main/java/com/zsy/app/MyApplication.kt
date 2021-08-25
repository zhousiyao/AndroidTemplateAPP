package com.zsy.app

import android.app.Application
import android.content.Context
import com.zsy.basemodule.base.utils.LogUtils.e

class MyApplication : Application() {

    val TAG = "MyApplication"
    override fun onCreate() {
        super.onCreate()
        e(" $TAG onCreate")
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        e(" $TAG attachBaseContext")
    }
}