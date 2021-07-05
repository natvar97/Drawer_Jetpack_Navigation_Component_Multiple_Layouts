package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.api

import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderRandomJokes {

    private fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_JOKES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val randomJokeApiService = getInstance().create(ApiService::class.java)

}