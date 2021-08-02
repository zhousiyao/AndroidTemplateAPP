package com.zsy.basemodule.base.init

import android.content.Context
import androidx.startup.Initializer
import com.zsy.basemodule.base.utils.PropertiesUtil.getProperty
import com.zsy.basemodule.base.utils.PropertiesUtil.init

class LibBaseInitializer : Initializer<Any> {

    override fun create(context: Context): Any {
        // 获取配置信息，进行一些初始化的设置
        init(context)
        val tag = getProperty("tag")
        val isShowLog = getProperty("isShowLog")
        //        Logger.init(TextUtils.isEmpty(tag) ? "TAG" : tag,
//                !TextUtils.equals(isShowLog, "false"));
//        AppCache.get().init(context, tag);
//        Logger.i("LibBaseInitializer create: ");
        return "create() complete！"
    }

    override fun dependencies(): List<Class<out Initializer<*>?>> {
//        List<Class<? extends Initializer<?>>> list = new ArrayList<>();
//        list.add(OtherInitializer.cla
//        ss);
        return emptyList()
    }
}