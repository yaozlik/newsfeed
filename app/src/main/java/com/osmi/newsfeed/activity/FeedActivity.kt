package com.osmi.newsfeed.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.osmi.newsfeed.R
import com.osmi.newsfeed.activity.base.BaseActivity
import com.osmi.newsfeed.adapter.ArticlesAdapter
import com.osmi.newsfeed.data.database.SQLiteHelper
import com.osmi.newsfeed.data.database.SQLiteHelper.Companion.DATA_BASE_NAME
import com.osmi.newsfeed.data.database.SQLiteHelper.Companion.DATA_BASE_VERSION
import com.osmi.newsfeed.data.repository.FeedRepository
import com.osmi.newsfeed.dto.Doc
import com.osmi.newsfeed.mvp.presenter.FeedPresenter
import com.osmi.newsfeed.mvp.view.FeedView
import kotlinx.android.synthetic.main.content_main.articlesRv

class FeedActivity : BaseActivity(), FeedView{

    lateinit var presenter: FeedPresenter
    lateinit var feedRecycler: RecyclerView
    lateinit var adapter: ArticlesAdapter
    var lastVisibleIitem: Int = 0
    var page = 0
    var offset: Int = 0
    var loading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        presenter = FeedPresenter(FeedRepository(SQLiteHelper(this, DATA_BASE_VERSION, DATA_BASE_NAME)))
        presenter.bind(this)
        bindElements()
        presenter.searchArticles(getApiKey(), "election", page)
    }

    override fun updateArticles(updated: ArrayList<Doc>) {
        adapter.update(updated)
        loading = false
    }

    override fun setNumberOfArticles(number: Int) {
        this.offset = number
    }

    private fun bindElements() {
        feedRecycler = articlesRv
        adapter = ArticlesAdapter()
        val layoutManager = LinearLayoutManager(this)
        feedRecycler.layoutManager = layoutManager
        feedRecycler.adapter = adapter

        feedRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = feedRecycler.layoutManager as LinearLayoutManager
                lastVisibleIitem = layoutManager.findLastCompletelyVisibleItemPosition()

                if (lastVisibleIitem > offset - 2 && !loading) {
                    updateData()
                }
            }
        })
    }

    private fun updateData() {
        loading = true
        page += 1
        presenter.searchArticles(getApiKey(), "election", page)
    }
}
