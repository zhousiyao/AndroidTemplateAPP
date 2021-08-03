//package com.zsy.basemodule.common.glide
//
//import com.bumptech.glide.annotation.GlideExtension
//import com.bumptech.glide.annotation.GlideOption
//import com.bumptech.glide.load.MultiTransformation
//import com.bumptech.glide.load.resource.bitmap.CenterCrop
//import com.bumptech.glide.request.BaseRequestOptions
//import com.zsy.basemodule.common.R
//import com.zsy.basemodule.common.utils.DisplayUtil
//import jp.wasabeef.glide.transformations.RoundedCornersTransformation
//
//@GlideExtension
//object CommonGlideExtension {
//
//    @GlideOption
//    fun applyAvatar(options: BaseRequestOptions<*>, size: Int): BaseRequestOptions<*> {
//        return options
//                .placeholder(R.mipmap.img_avatar_default)
//                .error(R.mipmap.img_avatar_default)
//                .override(size)
//                .circleCrop()
//    }
//
//    @GlideOption
//    fun applyAlbumPic(options: BaseRequestOptions<*>, size: Int, radius:Int) : BaseRequestOptions<*>{
//        return options
//                .override(size)
//                .transform(MultiTransformation(CenterCrop()),
//                        RoundedCornersTransformation(DisplayUtil.dp2px(radius.toFloat()),0))
//    }
//}