package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.api

import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderNews {

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApiService = getInstance().create(ApiService::class.java)

}