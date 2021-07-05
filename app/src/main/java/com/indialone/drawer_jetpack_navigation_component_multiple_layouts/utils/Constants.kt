package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.utils

import java.text.SimpleDateFormat
import java.util.*

object Constants {

    const val BASE_URL_ANIMALS = "https://elephant-api.herokuapp.com/"
    const val END_POINT_ANIMALS = "elephants"

    const val BASE_URL_JOKES = "https://official-joke-api.appspot.com/"
    const val END_POINT_JOKES = "random_joke"

    const val BASE_URL_CATS = "https://catfact.ninja/"
    const val END_POINT_CATS = "fact"

    // date
    val c: Date = Calendar.getInstance().getTime()
    val df: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    val formattedDate: String = df.format(c);

    // news
    const val BASE_URL_NEWS = "https://newsapi.org/v2/"
    const val API_KEY_NEWS = "f0ff90e809ef4848885fad9b2250cd17"

    const val COUNTRY = "in"
    const val CATEGORY = "business"
    const val SOURCES = "techcrunch"
    const val DOMAINS = "wsj.com"
    const val Q_TESLA = "tesla"
    val FROM = formattedDate
    const val SORT_BY = "publishedAt"
    const val Q_APPLE = "apple"
    val FROM_APPLE = formattedDate
    val TO_APPLE = formattedDate
    const val SORT_BY_APPLE = "popularity"


}