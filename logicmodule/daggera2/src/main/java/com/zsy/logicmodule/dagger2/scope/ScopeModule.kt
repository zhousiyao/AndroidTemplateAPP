package com.zsy.logicmodule.dagger2.scope

import dagger.Module
import dagger.Provides

@Module
class ScopeModule {

    @Provides
    fun provideScope() : ScopeClass{
        return ScopeClass()
    }
}