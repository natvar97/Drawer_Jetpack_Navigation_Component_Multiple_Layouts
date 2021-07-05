package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.repository.ApiRepository
import java.lang.IllegalArgumentException

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimalViewModel::class.java)) {
            return AnimalViewModel(ApiRepository()) as T
        }
        if (modelClass.isAssignableFrom(RandomJokeViewModel::class.java)) {
            return RandomJokeViewModel(ApiRepository()) as T
        }
        if (modelClass.isAssignableFrom(CatFactViewModel::class.java)) {
            return CatFactViewModel(ApiRepository()) as T
        }
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(ApiRepository()) as T
        }
        throw IllegalArgumentException("Unknown View Model class found")
    }
}