package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.cat_fact.CatFactEntity
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.repository.ApiRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class CatFactViewModel(
    private val repository: ApiRepository
) : ViewModel() {

    private val catFacts = MutableLiveData<CatFactEntity>()

    init {
        fetchCatFact()
    }

    fun fetchCatFact() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val fact = async {
                        repository.getRandomCatFact()
                    }
                    catFacts.postValue(fact.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getCatFact(): LiveData<CatFactEntity> = catFacts

}