package com.osmi.newsfeed.data.callback

import com.osmi.newsfeed.data.api.response.ArticlesResponse

interface ArticlesCallBack {
    fun onSuccess(articles: ArticlesResponse)

    fun onError(error: String)
}