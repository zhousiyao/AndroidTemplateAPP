package com.zsy.basemodule.base.utils;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;

public class GSON {

    private static WeakReference<Gson> instance;

    private GSON() {

    }

    public static Gson get() {
        if (instance == null || instance.get() == null) {
            Gson gson = new Gson();
            instance = new WeakReference<>(gson);
        }
        return instance.get();
    }

}
