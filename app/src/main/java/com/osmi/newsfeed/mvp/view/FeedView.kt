package com.osmi.newsfeed.mvp.view

import com.osmi.newsfeed.dto.Doc

interface FeedView {

    fun updateArticles(updated: ArrayList<Doc>)

    fun setNumberOfArticles(number: Int)
}