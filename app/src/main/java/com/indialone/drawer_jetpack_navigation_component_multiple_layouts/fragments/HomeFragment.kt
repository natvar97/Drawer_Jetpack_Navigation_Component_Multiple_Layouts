package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.R
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.adapters.ViewPagerAdapter
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = listOf(
            TopHeadlinesFragment(),
            TechCrunchFragment(),
            AppleNewsFragment(),
            TeslaNewsFragment(),
            WsjNewsFragment()
        )

        val tabTitles =
            arrayListOf("TopHeadlines", "TechCrunch", "Apple", "Tesla", "Wsj.com")
        mBinding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mBinding.viewPager.adapter = ViewPagerAdapter(fragmentList , requireActivity())
        TabLayoutMediator(mBinding.tabLayout , mBinding.viewPager ) { tab , position ->
            tab.text = tabTitles[position]
        }.attach()

    }

}