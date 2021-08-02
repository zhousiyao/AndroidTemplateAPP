package com.zsy.basemodule.base.cache

import android.content.Context
import com.zsy.basemodule.base.utils.FileUtil.deleteDirFiles
import com.zsy.basemodule.base.utils.FileUtil.makeDir
import java.io.File

/**
 * App频繁用到文件缓存，在这初始化，操作和管理等
 */
class AppCache {
    private var aCache: ACache? = null

    private object Holder {
        var INSTANCE = AppCache()
    }

    fun init(context: Context, cacheName: String?) {
        // 初始化Preferences
        Preferences.init(context)
        // 初始化App文件夹
        initAppDir(context, cacheName)
        // 初始化ACache
        aCache = ACache[context, cacheName]
    }

    fun initAppDir(context: Context, cacheName: String?) {
        val mainDir = File(context.cacheDir.absolutePath, cacheName)
        val fileDir = File(mainDir.absolutePath, "file")
        val tempDir = File(mainDir.absolutePath, "temp")
        makeDir(mainDir)
        makeDir(fileDir)
        makeDir(tempDir)
        // 每次初始化时删除临时文件
        deleteDirFiles(tempDir)
    }

    fun save(key: String?, value: String?) {
        aCache!!.put(key!!, value)
    }

    fun getString(key: String?): String? {
        return aCache!!.getAsString(key!!)
    }

    fun remove(key: String?) {
        aCache!!.remove(key!!)
    }

    companion object {
        fun get(): AppCache {
            return Holder.INSTANCE
        }
    }
}