package com.zsy.logicmodule.dagger2.di

import com.zsy.logicmodule.dagger2.Dagger2MainActivity
import dagger.Component

@Component(modules = [ProvideInstance::class])
interface ApplicationComponent {

    fun inject(dagger2MainActivity : Dagger2MainActivity)
}