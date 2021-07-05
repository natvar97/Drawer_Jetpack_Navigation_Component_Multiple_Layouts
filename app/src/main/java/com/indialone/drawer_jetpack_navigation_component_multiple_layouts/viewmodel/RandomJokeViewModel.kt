package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.joke.JokeEntity
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.repository.ApiRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class RandomJokeViewModel(
    private val repository: ApiRepository
) : ViewModel() {

    private val randomJoke = MutableLiveData<JokeEntity>()

    init {
        fetchRandomJoke()
    }

    fun fetchRandomJoke() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val joke = async {
                        repository.getRandomJokes()
                    }
                    randomJoke.postValue(joke.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getRandomJoke(): LiveData<JokeEntity> = randomJoke

}