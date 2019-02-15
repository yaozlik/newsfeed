package com.osmi.newsfeed.mvp.presenter

import android.util.Log
import com.osmi.newsfeed.data.api.response.ArticlesResponse
import com.osmi.newsfeed.data.callback.ArticlesCallBack
import com.osmi.newsfeed.data.repository.FeedRepository
import com.osmi.newsfeed.mvp.view.FeedView

class FeedPresenter (val repository: FeedRepository){

    private lateinit var view: FeedView

    fun bind(view: FeedView) {
        this.view = view
    }

    fun searchArticles(key: String, query: String, page: Int) {
        repository.searchArticles(key, query, page, object : ArticlesCallBack {
            override fun onSuccess(articles: ArticlesResponse) {
                view.updateArticles(articles.docs)
                view.setNumberOfArticles(articles.meta.offset)
            }

            override fun onError(error: String) {
                Log.d("error", error)
            }
        })
    }
}