package com.zsy.logicmodule.dagger2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.zsy.basemodule.base.utils.LogUtils
import com.zsy.logicmodule.dagger2.component.DaggerApplicationComponent
import com.zsy.logicmodule.dagger2.di.User
import javax.inject.Inject

class Dagger2MainActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2_main)
        Dagger2Application.applicationComponent.inject(this)
        LogUtils.e("User = ${user}")
//        LogUtils.e("AlertDialog = $alertDialog")

    }

    fun jumpToSecond(view: View) {
        startActivity(Intent(this,Dagger2SecondActivity::class.java))
    }
}