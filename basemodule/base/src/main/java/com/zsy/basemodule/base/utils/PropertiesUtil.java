package com.zsy.basemodule.base.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件的工具
 * （暂用方案）
 */
public class PropertiesUtil {

    private static Properties props;

    public static void init(Context c) {
        props = new Properties();
        InputStream in = null;
        try {
            //File file = new File("/appConfig.properties");
            //InputStream in = new FileInputStream(file);
            in = c.getAssets().open("appConfig.properties");
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

}
