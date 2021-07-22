package com.zsy.logicmodule.dagger2.component

import android.app.Application
import com.zsy.logicmodule.dagger2.Dagger2MainActivity
import com.zsy.logicmodule.dagger2.Dagger2SecondActivity
import com.zsy.logicmodule.dagger2.di.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(dagger2MainActivity : Dagger2MainActivity)
    fun inject(dagger2SecondActivity: Dagger2SecondActivity)

}