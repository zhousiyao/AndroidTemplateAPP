package com.zsy.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.zsy.app.test.activity.Instance01Activity;
import com.zsy.basemodule.base.utils.LogUtils;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 0;
        if(savedInstanceState != null) {
            a = savedInstanceState.getInt("aaa", 123);
        }
        LogUtils.INSTANCE.e("onCreate() = "+a);

        tv = findViewById(R.id.tv_hello);

        tv.setOnClickListener(
          view -> {
              startActivity(new Intent(MainActivity.this,Instance01Activity.class));
          }
        );

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        LogUtils.INSTANCE.e("onWindowFocusChanged()");
//        LogUtils.INSTANCE.e("onWindowFocusChanged() "+tv.getWidth());
//        LogUtils.INSTANCE.e("onWindowFocusChanged()"+tv.getHeight());
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