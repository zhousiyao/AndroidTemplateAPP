package com.zsy.logicmodule.dagger2.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

//    lateinit var context: Context
//
//    constructor(context: Context) {
//        this.context = context
//    }
//
//    fun provideContext() : Context{
//        return context
//    }

//    @Provides
//    fun provideDialog(context: Context):AlertDialog{
//        return AlertDialog.Builder(context).create()
//    }

//    @Provides
//    fun provideScopeClass():ScopeClass{
//        return ScopeClass()
//    }

    @Provides
    fun provideDependInstance():User{
        return User("Provides提供的")
    }
}