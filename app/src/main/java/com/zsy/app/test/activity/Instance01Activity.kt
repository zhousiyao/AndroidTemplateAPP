package com.zsy.app.test.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zsy.app.R
import com.zsy.basemodule.base.utils.LogUtils
import com.zsy.basemodule.base.utils.LogUtils.e

class Instance01Activity : AppCompatActivity() {

    val TAG = "Instance01Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.e("$TAG  onCreate()")
        setContentView(R.layout.activity_instance01)
    }

    fun toInstance02(view: View) {

        startActivity(Intent(this,Instance02Activity::class.java))
    }

    override fun onStart() {
        super.onStart()
        e("$TAG  onStart()")
    }

    override fun onResume() {
        super.onResume()
        e("$TAG  onResume()")
    }

    override fun onPause() {
        super.onPause()
        e("$TAG  onPause()")
    }

    override fun onStop() {
        super.onStop()
        e("$TAG  onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        e("$TAG  onDestroy()")
    }
}