package com.osmi.newsfeed.data.repository


import com.osmi.newsfeed.data.api.ApiManager.getArticlesApi
import com.osmi.newsfeed.data.api.response.GeneralArticleResponse
import com.osmi.newsfeed.data.callback.ArticlesCallBack
import com.osmi.newsfeed.data.database.SQLiteHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK

class FeedRepository (val helper: SQLiteHelper){

    fun searchArticles(key: String, query: String, page: Int, cb: ArticlesCallBack) {
        val call = getArticlesApi().search(key, query, page)
        call.enqueue(object : Callback<GeneralArticleResponse> {

            override fun onResponse(call: Call<GeneralArticleResponse>, response: Response<GeneralArticleResponse>) {
                if (response.code() == HTTP_OK) {
                    response.body()?.let {
                        cb.onSuccess(it.response)
                    }
                } else {
                    cb.onError("error")
                }
            }

            override fun onFailure(call: Call<GeneralArticleResponse>, t: Throwable) {
                cb.onError(t.message!!)
            }
        })
    }
}