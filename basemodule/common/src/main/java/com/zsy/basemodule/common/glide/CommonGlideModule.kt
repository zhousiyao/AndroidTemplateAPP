package com.zsy.basemodule.common.glide

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class CommonGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        val build = MemorySizeCalculator.Builder(context)
                .setMemoryCacheScreens(2f)
                .build()
        builder.setMemoryCache(LruResourceCache(build.memoryCacheSize.toLong()))
    }
}