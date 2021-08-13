package com.zsy.app.test

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.zsy.app.R

class TestRecycleViewAdapter(val dataList: List<Int>) :
    RecyclerView.Adapter<TestRecycleViewAdapter.MyRecycleViewHolder>() {

    inner class MyRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_bitmap_memory_manage,null)
        val holder = MyRecycleViewHolder(itemView)

        return  holder
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyRecycleViewHolder, position: Int) {
        (holder.imageView as ImageView).setImageResource(dataList[position])
    }
}