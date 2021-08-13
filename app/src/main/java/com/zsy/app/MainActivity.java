package com.zsy.app;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.zsy.basemodule.base.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 0;
        if(savedInstanceState != null) {
            a = savedInstanceState.getInt("aaa", 123);
        }
        LogUtils.INSTANCE.e("onCreate() = "+a);
    }

    @Override
    protected void onStart() {
        super.onStart();

        LogUtils.INSTANCE.e("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        LogUtils.INSTANCE.e("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        LogUtils.INSTANCE.e("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        LogUtils.INSTANCE.e("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        LogUtils.INSTANCE.e("onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("aaa",222);
        LogUtils.INSTANCE.e("onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.INSTANCE.e("onRestoreInstanceState() ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

    }

}