package com.zsy.logicmodule.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zsy.basemodule.base.utils.LogUtils
import com.zsy.logicmodule.dagger2.di.DaggerApplicationComponent
import com.zsy.logicmodule.dagger2.di.User
import javax.inject.Inject

class Dagger2MainActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2_main)
        DaggerApplicationComponent.create().inject(this)
        LogUtils.e("User = ${user.name}")
//        LogUtils.e("AlertDialog = $alertDialog")
    }
}