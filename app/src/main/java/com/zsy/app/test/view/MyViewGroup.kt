package com.zsy.app.test.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup
import com.zsy.basemodule.base.utils.LogUtils

class MyViewGroup: ViewGroup {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        LogUtils.e("MyViewGroup —— onMeasure 调用")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        LogUtils.e("MyViewGroup —— onLayout 调用")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        LogUtils.e("MyViewGroup —— onDraw 调用")
    }
}