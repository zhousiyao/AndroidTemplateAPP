package com.zsy.logicmodule.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zsy.basemodule.base.utils.LogUtils
import com.zsy.logicmodule.dagger2.di.User
import javax.inject.Inject

class Dagger2SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2_second)
        Dagger2Application.applicationComponent.inject(this)

        LogUtils.e("Dagger2SecondActivity  User = $user")
    }
}