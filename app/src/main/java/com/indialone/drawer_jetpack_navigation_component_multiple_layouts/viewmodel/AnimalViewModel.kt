package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.animal.AnimalItem
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.animal.Animals
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.repository.ApiRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class AnimalViewModel(
    private val repository: ApiRepository
) : ViewModel() {

    private val animals = MutableLiveData<List<AnimalItem>>()

    init {
        fetchAnimals()
    }

    private fun fetchAnimals() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val animalList = async {
                        repository.getAllElephants()
                    }
                    animals.postValue(animalList.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getAllElephants(): LiveData<List<AnimalItem>> = animals

}