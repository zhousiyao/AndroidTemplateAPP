package com.zsy.basemodule.base.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.util.*

/**
 * 读取本地Assets目录配置文件的工具
 * （暂用方案）
 */
object PropertiesUtil {
    private var props: Properties? = null

    @JvmStatic
    fun init(c: Context) {
        props = Properties()
        var `in`: InputStream? = null
        try {
            //File file = new File("/appConfig.properties");
            //InputStream in = new FileInputStream(file);
            `in` = c.assets.open("appConfig.properties")
            props!!.load(`in`)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (`in` != null) {
                try {
                    `in`.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    @JvmStatic
    fun getProperty(key: String?): String {
        return props!!.getProperty(key)
    }
}