package com.zsy.basemodule.common.base

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.zsy.basemodule.base.utils.ReflectUtil
import com.zsy.basemodule.common.mvp.IView
import com.zsy.basemodule.common.widget.LoadingDialog
import java.lang.RuntimeException

class BaseFragment<T : ViewBinding> : Fragment(), IView {

    lateinit var binding:T
    private lateinit var loadingDialog: LoadingDialog

    /**
     * 填充布局
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //基本吃初始化
        initView()
        loadData()
        initLiveData()

        return inflateRootView()
    }

    private fun initLiveData() {
        TODO("Not yet implemented")
    }

    private fun loadData() {
        TODO("Not yet implemented")
    }

    private fun initView() {
        TODO("Not yet implemented")
    }

    /**
     * 通过反射拿到RootView并返回
     */
    private fun inflateRootView(): View? {
        var rootView:View? = null
        //利用反射拿到 Fragment对应的ViewBinding
        val clz : Class<*>  = ReflectUtil.analysisClassInfo(this)
        if(clz != ViewBinding::class.java && ViewBinding::class.java.isAssignableFrom(clz)){
            //通过反射拿到ViewBinding对应的inflate方法
            val method = clz.getDeclaredMethod("inflate",LayoutInflater::class.java)
            method.isAccessible = true
            binding = method.invoke(null,layoutInflater) as T
            rootView = binding?.root
        }

        if(rootView == null){
            throw RuntimeException("RootView can not be null !!!")
        }

        return rootView
    }

    override fun showLoading(msg: String) {
        var realMsg = "加载中..."
        if(!TextUtils.isEmpty(msg)) realMsg = msg
        if(loadingDialog == null){
            loadingDialog = LoadingDialog(activity!!)
        }
        if(loadingDialog.isShowing && TextUtils.equals(loadingDialog.message, realMsg)){
            return
        }
        loadingDialog.setType(LoadingDialog.TYPE_LOADING)
        loadingDialog.setMessage(realMsg)
        if(!activity!!.isDestroyed && !loadingDialog.isShowing){
            loadingDialog.show()
        }

    }

    override fun dismissLoading() {
        if(loadingDialog != null && loadingDialog.isShowing){
            loadingDialog.dismiss()
        }
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