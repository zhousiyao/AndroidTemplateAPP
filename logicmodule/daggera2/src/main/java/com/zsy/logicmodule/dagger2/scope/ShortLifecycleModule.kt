package com.zsy.logicmodule.dagger2.scope

import com.zsy.logicmodule.dagger2.anno.ShortLifecycleAnno
import dagger.Module
import dagger.Provides

@Module
class ShortLifecycleModule {

    @ShortLifecycleAnno
    @Provides
    fun provideScope() : ShortLifecycleA{
        return ShortLifecycleA()
    }
}