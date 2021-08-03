package com.zsy.basemodule.common.utils

import android.content.Context
import com.zsy.basemodule.common.widget.LoadingDialog

/**
 * 显示仿IOS的Loading Dialog
 */
object DialogUtil {
    fun showLoadingMsg(context: Context?, message: String?, iconRes: Int, duration: Int): LoadingDialog {
        val dialog = LoadingDialog(context!!)
        dialog.setType(LoadingDialog.TYPE_MSG)
                .setMessage(message)
                .setIcon(iconRes)
        dialog.dismissDelayed(duration)
        return dialog
    }

    fun showLoading(context: Context?, message: String?): LoadingDialog {
        val dialog = LoadingDialog(context!!)
        dialog.setType(LoadingDialog.TYPE_LOADING)
                .setMessage(message)
        return dialog
    }
}