package com.osmi.newsfeed.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiManager {
    //
    const val BASE_URL = "https://api.nytimes.com/svc/"
    const val SEARCH_PATH = "search/v2/"

    fun getArticlesApi(): ArticlesApi {
        return getRealmInstance().create(ArticlesApi::class.java)
    }

    fun getRealmInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
}