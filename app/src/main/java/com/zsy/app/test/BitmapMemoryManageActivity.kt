package com.zsy.app.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zsy.app.R
import com.zsy.basemodule.base.utils.LogUtils

class BitmapMemoryManageActivity : AppCompatActivity() {

    lateinit var rList:RecyclerView
    lateinit var dataList:List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_memory_manage)

        rList = findViewById(R.id.rv_test)

        initData()
        rList.layoutManager = LinearLayoutManager(this)
        rList.adapter = TestRecycleViewAdapter(dataList)
        LogUtils.e(dataList.toString())
    }

    private fun initData() {
        dataList = MutableList(10,init = {
            R.mipmap.img_music2
        })
    }
}