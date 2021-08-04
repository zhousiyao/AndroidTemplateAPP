package com.zsy.basemodule.common.di

import com.zsy.basemodule.common.model.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    //提供Application纬度
    fun getApiService(retrofit: Retrofit) : ApiService{

        return retrofit.create(ApiService::class.java)
    }
}