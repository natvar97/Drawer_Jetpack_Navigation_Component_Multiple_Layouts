package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.news.NewsEntity
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.repository.ApiRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: ApiRepository
) : ViewModel() {

    private val topHeadlines = MutableLiveData<NewsEntity>()
    private val techCrunchNews = MutableLiveData<NewsEntity>()
    private val appleNews = MutableLiveData<NewsEntity>()
    private val teslaNews = MutableLiveData<NewsEntity>()
    private val wsjComNews = MutableLiveData<NewsEntity>()

    init {
        fetchTopHeadlines()
        fetchTechCrunchNews()
        fetchAppleNews()
        fetchTeslaNews()
        fetchWsjComNews()
    }

    fun fetchWsjComNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        newsRepository.getWsjComNews()
                    }
                    wsjComNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun fetchTeslaNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        newsRepository.getTeslaNews()
                    }
                    teslaNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun fetchAppleNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        newsRepository.getAppleNews()
                    }
                    appleNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun fetchTechCrunchNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        newsRepository.getTechCrunchNews()
                    }
                    techCrunchNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        newsRepository.getTopHeadlines()
                    }
                    topHeadlines.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getTopHeadlines(): LiveData<NewsEntity> = topHeadlines
    fun getTechCrunchNews(): LiveData<NewsEntity> = techCrunchNews
    fun getAppleNews(): LiveData<NewsEntity> = appleNews
    fun getTeslaNews(): LiveData<NewsEntity> = teslaNews
    fun getWsjComNews(): LiveData<NewsEntity> = wsjComNews

}