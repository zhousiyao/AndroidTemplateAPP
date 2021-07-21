package com.zsy.basemodule.base.utils

import android.util.Log

object LogUtils {

    var switch = false
    var target = "LogUtils-Base"

    fun switch(isClose : Boolean){
        switch = isClose
    }

    fun e(msg:String){
        if(!switch) Log.e(target,msg)
    }
    fun e(tar:String,msg:String){
        if(!switch) Log.e(tar,msg)
    }
}