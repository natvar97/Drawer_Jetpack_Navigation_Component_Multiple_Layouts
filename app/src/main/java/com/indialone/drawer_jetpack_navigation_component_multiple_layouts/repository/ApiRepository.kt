package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.repository

import androidx.annotation.WorkerThread
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.api.RetrofitBuilderAnimal
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.api.RetrofitBuilderCatFact
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.api.RetrofitBuilderNews
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.api.RetrofitBuilderRandomJokes
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.utils.Constants

class ApiRepository {

    @WorkerThread
    suspend fun getAllElephants() = RetrofitBuilderAnimal
        .animalsApiService.getAllElephants()

    @WorkerThread
    suspend fun getRandomJokes() = RetrofitBuilderRandomJokes
        .randomJokeApiService.getRandomJoke()

    @WorkerThread
    suspend fun getRandomCatFact() = RetrofitBuilderCatFact
        .randomCatFact
        .getRandomCatFact()

    @WorkerThread
    suspend fun getTopHeadlines() = RetrofitBuilderNews.newsApiService
        .getTopHeadlines(
            Constants.COUNTRY,
            Constants.CATEGORY,
            Constants.API_KEY_NEWS
        )

    @WorkerThread
    suspend fun getTechCrunchNews() = RetrofitBuilderNews.newsApiService
        .getTechCrunchNews(
            Constants.SOURCES,
            Constants.API_KEY_NEWS
        )

    @WorkerThread
    suspend fun getAppleNews() = RetrofitBuilderNews.newsApiService
        .getAppleNews(
            Constants.Q_APPLE,
            Constants.FROM_APPLE,
            Constants.TO_APPLE,
            Constants.SORT_BY_APPLE,
            Constants.API_KEY_NEWS
        )

    @WorkerThread
    suspend fun getTeslaNews() = RetrofitBuilderNews.newsApiService
        .getTeslaNews(
            Constants.Q_TESLA,
            Constants.FROM,
            Constants.SORT_BY,
            Constants.API_KEY_NEWS
        )

    @WorkerThread
    suspend fun getWsjComNews() = RetrofitBuilderNews.newsApiService
        .getWsjComNews(
            Constants.DOMAINS,
            Constants.API_KEY_NEWS
        )
}