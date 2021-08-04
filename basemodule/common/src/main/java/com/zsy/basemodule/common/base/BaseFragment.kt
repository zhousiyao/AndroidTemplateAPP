package com.zsy.basemodule.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.zsy.basemodule.common.mvp.IView

class BaseFragment<T : ViewBinding> : Fragment(), IView {

    /**
     * 填充布局
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflateRootView()


        return rootView
    }

    private fun inflateRootView(): View? {
        var rootView:View? = null
        //利用反射拿到 Fragment对应的ViewBinding

        return rootView
    }

    override fun showLoading(msg: String) {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }

    override fun showToast(msg: String) {
        TODO("Not yet implemented")
    }

    override fun showLoadingLayout() {
        TODO("Not yet implemented")
    }

    override fun showSuccessLayout() {
        TODO("Not yet implemented")
    }

    override fun showErrorLayout() {
        TODO("Not yet implemented")
    }

    override fun showEmptyLayout() {
        TODO("Not yet implemented")
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}