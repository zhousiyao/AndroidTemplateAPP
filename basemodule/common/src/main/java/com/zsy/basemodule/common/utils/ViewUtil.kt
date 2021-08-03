package com.zsy.basemodule.common.utils

import android.view.View

object ViewUtil {
    /**
     * 多个控件同时设置公用的OnClickListener
     *
     * @param listener
     * @param views
     */
    fun setOnClick(listener: View.OnClickListener?, vararg views: View) {
        for (view in views) {
            view.setOnClickListener(listener)
        }
    }
}