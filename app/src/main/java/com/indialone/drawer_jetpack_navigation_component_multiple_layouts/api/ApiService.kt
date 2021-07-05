package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.api

import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.animal.AnimalItem
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.animal.Animals
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.cat_fact.CatFactEntity
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.joke.JokeEntity
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.news.NewsEntity
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT_ANIMALS)
    suspend fun getAllElephants() : List<AnimalItem>

    @GET(Constants.END_POINT_JOKES)
    suspend fun getRandomJoke() : JokeEntity

    @GET(Constants.END_POINT_CATS)
    suspend fun getRandomCatFact() : CatFactEntity

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

    @GET("top-headlines")
    suspend fun getTechCrunchNews(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

    @GET("everything")
    suspend fun getTeslaNews(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity


    @GET("everything")
    suspend fun getAppleNews(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

    @GET("everything")
    suspend fun getWsjComNews(
        @Query("domains") domains: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity


}