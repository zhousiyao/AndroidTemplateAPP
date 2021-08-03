package com.zsy.basemodule.common.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.zsy.basemodule.common.R

/**
 * 自定义带进度的圆形播放/暂停按钮控件
 */
class PlayButtonView : View {
    /**
     * 默认外圆的线宽
     */
    private var defaultStateStrokeWidth = 0.0f

    /**
     * 进度画笔的线宽
     */
    private var progressStateStrokeWidth = 0.0f

    /**
     * 中心点X轴坐标
     */
    private var viewCenterX = 0

    /**
     * 中心点Y轴坐标
     */
    private var viewCenterY = 0

    /**
     * 有效长度的一般（View长宽较小者的一半）
     */
    private var viewHalfLength = 0

    /**
     * 三角形右侧顶点
     */
    private val pointA = Point()

    /**
     * 三角形左上顶点
     */
    private val pointB = Point()

    /**
     * 三角形左下顶点
     */
    private val pointC = Point()

    /**
     * 矩形左边界
     */
    private var RectLeft = 0

    /**
     * 矩形上边界
     */
    private var RectTOP = 0

    /**
     * 矩形右边界
     */
    private var RectRight = 0

    /**
     * 矩形下边界
     */
    private var RectBottom = 0

    /**
     * 三角形的三条边路径
     */
    private val path = Path()

    /**
     * 包围最外侧圆环的矩形
     */
    private val rectF = RectF()

    /**
     * 包围进度圆弧的矩形
     */
    private val rectF2 = RectF()

    /**
     * 进度
     */
    private var progress = 0

    /**
     * 暂停中还是播放中
     */
    private var isPlaying = false

    /**
     * 是否进行过了测量
     */
    private var isMeasured = false

    /**
     * 默认画笔颜色
     */
    private var colorA = -0x99999a

    /**
     * 进度画笔颜色
     */
    private var colorB = -0x2cc5cf
    private var progressColorResId = 0

    /**
     * 最外侧圆环画笔
     */
    private val paintA = Paint()

    /**
     * 进度圆弧画笔
     */
    private val paintB = Paint()

    /**
     * 暂停开始画笔
     */
    private val paintC = Paint()

    /**
     * 构造器
     */
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initResources(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initResources(context, attrs)
    }

    private fun initResources(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.PlayButtonView)
        colorA = a.getColor(R.styleable.PlayButtonView_color_default, colorA)
        colorB = a.getColor(R.styleable.PlayButtonView_color_progress, colorB)
        progressColorResId = a.getResourceId(R.styleable.PlayButtonView_color_progress, 0)
        defaultStateStrokeWidth = a.getDimension(R.styleable.PlayButtonView_line_default_width, resources.getDimension(R.dimen.line_default_width_d))
        progressStateStrokeWidth = a.getDimension(R.styleable.PlayButtonView_line_progress_width, resources.getDimension(R.dimen.line_default_width_d))
        a.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (!isMeasured) {
            widthAndHeight
            isMeasured = true
        }
    }// 1/ 2
    //比原来的缩小1个像素的样子
// √(3) / 2//去锯齿设置
    //2f表示比原来的缩小2个像素的样子

    /**
     * 得到视图等的高度宽度尺寸数据
     */
    private val widthAndHeight: Unit
        private get() {
            val viewHeight = measuredHeight
            val viewWidth = measuredWidth
            viewCenterX = viewWidth / 2
            viewCenterY = viewHeight / 2
            viewHalfLength = if (viewHeight < viewWidth) viewHeight / 2 else viewWidth / 2
            val paintAWidth = defaultStateStrokeWidth
            val paintBWidth = progressStateStrokeWidth
            rectF.left = viewCenterX - (viewHalfLength - paintAWidth / 2)
            rectF.top = viewCenterY - (viewHalfLength - paintAWidth / 2)
            rectF.right = viewCenterX + (viewHalfLength - paintAWidth / 2)
            rectF.bottom = viewCenterY + (viewHalfLength - paintAWidth / 2)
            rectF2.left = viewCenterX - (viewHalfLength - paintBWidth / 2)
            rectF2.top = viewCenterY - (viewHalfLength - paintBWidth / 2)
            rectF2.right = viewCenterX + (viewHalfLength - paintBWidth / 2)
            rectF2.bottom = viewCenterY + (viewHalfLength - paintBWidth / 2)
            paintA.color = colorA
            paintA.strokeWidth = paintAWidth
            paintA.isAntiAlias = true //去锯齿设置
            paintA.style = Paint.Style.STROKE
            paintB.color = colorB
            paintB.strokeWidth = paintBWidth
            paintB.isAntiAlias = true
            paintB.style = Paint.Style.STROKE
            paintC.color = colorA
            paintC.strokeWidth = 0.5f
            paintC.isAntiAlias = true
            paintC.style = Paint.Style.FILL
            pointA.x = viewCenterX + viewHalfLength / 2 - 2f //2f表示比原来的缩小2个像素的样子
            pointA.y = viewCenterY.toFloat()
            val sin = Math.sin(Math.toRadians(60.0)) // √(3) / 2
            val cos = Math.cos(Math.toRadians(60.0)) // 1/ 2
            pointB.x = ((viewCenterX - cos * viewHalfLength + viewCenterX) / 2).toFloat() + 2f
            pointB.y = ((viewCenterY - sin * viewHalfLength + viewCenterY) / 2).toFloat() + 2f
            pointC.x = ((viewCenterX - cos * viewHalfLength + viewCenterX) / 2).toFloat() + 2f
            pointC.y = ((viewCenterY + sin * viewHalfLength + viewCenterY) / 2).toFloat() - 2f
            RectLeft = viewCenterX - viewHalfLength / 3 + 1 //比原来的缩小1个像素的样子
            RectTOP = viewCenterY - viewHalfLength / 3 + 1
            RectRight = viewCenterX + viewHalfLength / 3 - 1
            RectBottom = viewCenterY + viewHalfLength / 3 - 1
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas) // 画未完成进度的圆环
        canvas.drawArc(rectF, 0f, 360f, false, paintA)
        // 画已经完成进度的圆弧 从-90度开始，即从圆环顶部开始
        canvas.drawArc(rectF2, -90f, progress * 3.6f, false, paintB)
        if (isPlaying) {
            paintC.color = colorB
            canvas.drawRect(RectLeft.toFloat(), RectTOP.toFloat(), RectRight.toFloat(), RectBottom.toFloat(), paintC)
        } else {
            paintC.color = colorA
            path.reset()
            path.moveTo(pointA.x, pointA.y)
            path.lineTo(pointB.x, pointB.y)
            path.lineTo(pointC.x, pointC.y)
            path.close()
            canvas.drawPath(path, paintC)
        }
    }

    /**
     * 设置进度 0-100区间
     */
    fun setProgress(progress: Int) {
        var progress = progress
        if (progress < 0) {
            progress = 0
        }
        if (progress > 100) {
            progress = 100
        }
        this.progress = progress
        invalidate()
    }

    fun getProgress(): Int {
        return progress
    }

    /**
     * 外界设置播放状态
     */
    fun setPlaying(isPlaying: Boolean) {
        this.isPlaying = isPlaying
        invalidate()
    }

    fun isPlaying(): Boolean {
        return isPlaying
    }

    /**
     * 位置信息
     */
    private inner class Point {
        var x = 0f
        var y = 0f
    }
}