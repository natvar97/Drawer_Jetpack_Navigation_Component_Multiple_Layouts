package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.R
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.FragmentNewsDetailsBinding
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.news.ArticlesItem

class FragmentNewsDetails : Fragment() {

    private lateinit var mBinding: FragmentNewsDetailsBinding
    private var news: ArticlesItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            news = arguments?.getParcelable("news")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNewsDetailsBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        news?.let {
            mBinding.tvAuthor.text = news!!.author
            mBinding.tvContent.text = news!!.content
            mBinding.tvTitle.text = news!!.title
            mBinding.tvDescription.text = news!!.description
            mBinding.tvPublishedAt.text = news!!.publishedAt
            Glide.with(mBinding.root.context)
                .load(news!!.urlToImage)
                .centerCrop()
                .into(mBinding.ivImageNews)
            mBinding.tvUrl.text = news!!.url
        }

    }
}