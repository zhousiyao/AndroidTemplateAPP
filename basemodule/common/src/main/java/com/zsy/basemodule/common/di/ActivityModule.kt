//package com.zsy.basemodule.common.di
//
//import android.app.Activity
//import androidx.core.app.ActivityCompat
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.scopes.ActivityScoped
//
//@Module
//@InstallIn(ActivityCompat::class)
//class ActivityModule {
//
//    //提供Activity生命周期维度的对象
//    @ActivityScoped
//    @Provides
//    open fun providerString(activity: Activity?): String? {
//        return "test !!!"
//    }
//}