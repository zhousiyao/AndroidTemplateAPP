package com.zsy.app.test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.zsy.app.R

class ViewTestActivity : AppCompatActivity() {

    lateinit var myViewGroup:MyViewGroup
    lateinit var myView:MyView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_test)
        myViewGroup = MyViewGroup(this)
        myView = MyView(this)
        myViewGroup.addView(myView)
        findViewById<ConstraintLayout>(R.id.cl_container).addView(myViewGroup)
    }

    fun myRequestLayout(view: View) {

//        myView.requestLayout()
        myView.invalidate()
//        myView.postInvalidate()
    }
}