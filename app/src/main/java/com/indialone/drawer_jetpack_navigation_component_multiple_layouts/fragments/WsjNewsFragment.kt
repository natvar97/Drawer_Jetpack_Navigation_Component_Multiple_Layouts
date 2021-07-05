package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.R
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.adapters.NewsItemAdapter
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.FragmentWsjNewsBinding
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.news.ArticlesItem
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.NewsViewModel
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.ViewModelFactory

class WsjNewsFragment : Fragment() {

    private lateinit var mBinding: FragmentWsjNewsBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentWsjNewsBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel = ViewModelProvider(this, ViewModelFactory()).get(NewsViewModel::class.java)

        newsViewModel.getWsjComNews().observe(viewLifecycleOwner) { newsEntity ->
            if(mBinding.swipeToRefresh.isRefreshing) {
                mBinding.swipeToRefresh.isRefreshing = false
            }
            mBinding.rvNews.layoutManager = LinearLayoutManager(mBinding.root.context)
            mBinding.rvNews.adapter =
                NewsItemAdapter(newsEntity.articles as ArrayList<ArticlesItem>)
        }

        mBinding.swipeToRefresh.setOnRefreshListener {
            newsViewModel.fetchWsjComNews()
        }

    }

}