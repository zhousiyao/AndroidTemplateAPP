package com.zsy.basemodule.common.arouter

import com.alibaba.android.arouter.launcher.ARouter
import com.zsy.basemodule.common.arouter.constant.RoutePath
import com.zsy.basemodule.common.arouter.constant.SimplePage

object PageHelper {
    fun showActivity(path: String?) {
        ARouter.getInstance().build(path).navigation()
    }

    fun showSimplePage(simplePage: SimplePage) {
        ARouter.getInstance().build(RoutePath.SIMPLE_PAGE_ACTIVITY)
                .withString("title", simplePage.title)
                .withString("path", simplePage.path)
                .navigation()
    }
}