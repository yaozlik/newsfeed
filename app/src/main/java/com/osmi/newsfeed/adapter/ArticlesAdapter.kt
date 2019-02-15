package com.osmi.newsfeed.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.osmi.newsfeed.dto.Doc
import com.osmi.newsfeed.holder.ArticlesHolder

class ArticlesAdapter(var articles: ArrayList<Doc> = ArrayList()) :
    RecyclerView.Adapter<ArticlesHolder>() {

    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): ArticlesHolder {
        return ArticlesHolder(viewgroup)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(viewHolder: ArticlesHolder, position: Int) {
        viewHolder.bind(articles[position])
    }

    fun update(updated: ArrayList<Doc>) {
        articles.addAll(updated)
        notifyDataSetChanged()
    }
}