package com.zsy.logicmodule.dagger2

import android.app.Application
import com.zsy.logicmodule.dagger2.component.ApplicationComponent
import com.zsy.logicmodule.dagger2.component.DaggerApplicationComponent

class Dagger2Application : Application() {

    companion object{
        @JvmStatic
        val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
    }
    override fun onCreate() {
        super.onCreate()
    }
}