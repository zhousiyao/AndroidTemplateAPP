package com.zsy.basemodule.common.di

import androidx.core.app.ActivityCompat
import dagger.Module
import dagger.hilt.InstallIn

@Module
@InstallIn(ActivityCompat::class)
class ActivityModule {

    //提供Activity生命周期维度的对象
}