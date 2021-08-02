package com.zsy.basemodule.base.cache

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * SharedPreferences管理类
 */
object Preferences {
    private var preferences: SharedPreferences? = null
    fun init(context: Context?) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return preferences!!.getBoolean(key, defValue)
    }

    fun saveBoolean(key: String?, value: Boolean) {
        preferences!!.edit().putBoolean(key, value).apply()
    }

    fun getInt(key: String?, defValue: Int): Int {
        return preferences!!.getInt(key, defValue)
    }

    fun saveInt(key: String?, value: Int) {
        preferences!!.edit().putInt(key, value).apply()
    }

    fun getLong(key: String?, defValue: Long): Long {
        return preferences!!.getLong(key, defValue)
    }

    fun saveLong(key: String?, value: Long) {
        preferences!!.edit().putLong(key, value).apply()
    }

    fun getString(key: String?, defValue: String?): String? {
        return preferences!!.getString(key, defValue)
    }

    fun saveString(key: String?, value: String?) {
        preferences!!.edit().putString(key, value).apply()
    }

    fun remove(key: String?) {
        preferences!!.edit().remove(key).apply()
    }
}