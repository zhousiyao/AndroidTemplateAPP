package com.zsy.basemodule.common.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object DisplayUtil {
    private var CONTEXT: Context? = null
    fun init(context: Context) {
        CONTEXT = context.applicationContext
    }

    val screenWidth: Int
        get() {
            val wm = CONTEXT!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            return wm.defaultDisplay.width
        }

    val screenHeight: Int
        get() {
            val wm = CONTEXT!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val outMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(outMetrics)
            return outMetrics.heightPixels
        }

    /**
     * 获取状态栏高度
     */
    val statusBarHeight: Int
        get() {
            var result = 0
            val resourceId = CONTEXT!!.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = CONTEXT!!.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }

    fun dp2px(dpValue: Float): Int {
        val scale = CONTEXT!!.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun px2dp(pxValue: Float): Int {
        val scale = CONTEXT!!.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun sp2px(spValue: Float): Int {
        val fontScale = CONTEXT!!.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}