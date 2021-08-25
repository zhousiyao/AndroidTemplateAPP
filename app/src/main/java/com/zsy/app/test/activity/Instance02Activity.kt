package com.zsy.app.test.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zsy.app.R
import com.zsy.basemodule.base.utils.LogUtils

class Instance02Activity : AppCompatActivity() {

    val TAG = "Instance02Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.e("$TAG  onCreate()")
        setContentView(R.layout.activity_instance02)
    }

    fun toTask01(view: View) {

        startActivity(Intent(this,Task01Activity::class.java))
    }

    override fun onStart() {
        super.onStart()
        LogUtils.e("$TAG  onStart()")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.e("$TAG  onResume()")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.e("$TAG  onPause()")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.e("$TAG  onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.e("$TAG  onDestroy()")
    }
}