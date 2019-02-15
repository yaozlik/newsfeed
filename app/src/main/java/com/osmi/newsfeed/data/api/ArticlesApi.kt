package com.osmi.newsfeed.data.api

import com.osmi.newsfeed.data.api.ApiManager.SEARCH_PATH
import com.osmi.newsfeed.data.api.response.GeneralArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApi {

    @GET(SEARCH_PATH + "articlesearch.json")
    fun search(
        @Query("api-key") key: String,
        @Query("q") query: String,
        @Query("page") page: Int
    ) : Call<GeneralArticleResponse>
}