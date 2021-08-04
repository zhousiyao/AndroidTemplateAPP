package com.zsy.basemodule.common.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.zsy.basemodule.common.utils.DisplayUtil

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //各种init
        ARouter.init(this)
        DisplayUtil.init(this)
    }
}