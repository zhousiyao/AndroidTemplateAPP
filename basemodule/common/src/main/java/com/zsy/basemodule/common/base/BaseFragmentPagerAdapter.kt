package com.zsy.basemodule.common.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class BaseFragmentPagerAdapter private constructor(fm: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fm, behavior) {

    private lateinit var fragmentList:List<Fragment>
    private lateinit var titles : ArrayList<String>

    constructor(
        fm: FragmentManager,
        behavior: Int,
        fragmentList: List<Fragment>,
        titles: ArrayList<String>
    ) : this(fm, behavior) {
        this.fragmentList = fragmentList
        this.titles = titles
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}