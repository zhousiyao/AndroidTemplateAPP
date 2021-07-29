package com.zsy.basemodule.okhttp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkhttpConfig {

    companion object{

        fun getLoggingInterceptor() : HttpLoggingInterceptor{

            return HttpLoggingInterceptor(
                   object : HttpLoggingInterceptor.Logger{
                       override fun log(message: String) {
                           TODO("Not yet implemented")
                       }
                   }
            ).setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        fun getOkhttpClient() : OkHttpClient{
            return OkHttpClient.Builder()
                    .connectTimeout(2,TimeUnit.SECONDS)
                    .writeTimeout(12,TimeUnit.SECONDS)
                    .readTimeout(60,TimeUnit.SECONDS)
                    .build()
        }
    }
}