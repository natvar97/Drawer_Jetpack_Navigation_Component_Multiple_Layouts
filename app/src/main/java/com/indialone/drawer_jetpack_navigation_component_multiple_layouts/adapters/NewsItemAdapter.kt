package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.R
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.NewsItemLayoutBinding
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.news.ArticlesItem

class NewsItemAdapter(
    private val news: ArrayList<ArticlesItem>
) : RecyclerView.Adapter<NewsItemAdapter.NewsItemViewHolder>() {
    class NewsItemViewHolder(itemView: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val tvTitle = itemView.tvNewsTitle
        private val tvAuthor = itemView.tvNewsAuthor
        private val tvPublishedAt = itemView.tvNewsPublishAt
        private val ivNewsImage = itemView.ivNews

        fun bind(article: ArticlesItem) {
            tvTitle.text = article.title
            tvAuthor.text = article.author
            tvPublishedAt.text = article.publishedAt
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .centerCrop()
                .into(ivNewsImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val view = NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val news = news[position]
        holder.bind(news)
        val bundle = bundleOf(
            "news" to news
        )
        holder.itemView.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_homeFragment_to_fragmentNewsDetails, bundle)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }
}