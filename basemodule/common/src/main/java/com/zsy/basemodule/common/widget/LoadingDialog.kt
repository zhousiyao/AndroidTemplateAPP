package com.zsy.basemodule.common.widget

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.zsy.basemodule.common.R

/**
 * 仿IOS Loading Dialog
 */
class LoadingDialog : Dialog {
    private var handler: Handler? = null
    private var mLayout: View? = null
    private var tvMsg: TextView? = null
    private var ivIcon: ImageView? = null
    private var pbLoading: ProgressBar? = null

    constructor(context: Context) : super(context, R.style.LoadingDialogTheme) {
        init(context)
    }

    constructor(context: Context, themeResId: Int) : super(context, themeResId) {
        init(context)
    }

    private fun init(context: Context) {
        window!!.setDimAmount(0f)
        handler = Handler(context.mainLooper)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mLayout = inflater.inflate(R.layout.layout_loading_dialog, null, false)
        tvMsg = mLayout!!.findViewById(R.id.tv_msg)
        ivIcon = mLayout!!.findViewById(R.id.iv_icon)
        pbLoading = mLayout!!.findViewById(R.id.pb_loading)
        setContentView(mLayout!!, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT))
        setCancelable(true) //用户可以点击后退键关闭 Dialog
        setCanceledOnTouchOutside(false) //用户可以点击外部来关闭
    }

    /**
     * 延时关闭
     *
     * @param duration
     */
    fun dismissDelayed(duration: Int) {
        handler!!.postDelayed({ dismiss() }, duration.toLong())
    }

    fun setTextColor(color: Int): LoadingDialog {
        tvMsg!!.setTextColor(color)
        return this
    }

    fun setIcon(resId: Int): LoadingDialog {
        ivIcon!!.setImageResource(resId)
        return this
    }

    fun setIcon(bitmap: Bitmap?): LoadingDialog {
        ivIcon!!.setImageBitmap(bitmap)
        return this
    }

    fun setMessage(message: String?): LoadingDialog {
        tvMsg!!.text = message
        return this
    }

    fun setCancel(b: Boolean): LoadingDialog {
        super.setCancelable(b)
        return this
    }

    fun setCancelOnTouchOutside(b: Boolean): LoadingDialog {
        super.setCanceledOnTouchOutside(b)
        return this
    }

    val message: String
        get() {
            var msg = ""
            if (tvMsg != null) {
                msg = tvMsg!!.text.toString()
            }
            return msg
        }

    /**
     * 禁止手动取消
     *
     * @return
     */
    fun setCancelDisabled(): LoadingDialog {
        super.setCanceledOnTouchOutside(false)
        super.setCancelable(false)
        return this
    }

    /**
     * 设置为loading还是msg对话框
     *
     * @param type
     * @return
     */
    fun setType(type: Int): LoadingDialog {
        when (type) {
            TYPE_LOADING -> {
                pbLoading!!.visibility = View.VISIBLE
                ivIcon!!.visibility = View.GONE
            }
            TYPE_MSG -> {
                pbLoading!!.visibility = View.GONE
                ivIcon!!.visibility = View.VISIBLE
            }
        }
        return this
    }

    companion object {
        const val TYPE_LOADING = 1
        const val TYPE_MSG = 2
    }
}