package com.osmi.newsfeed.holder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.osmi.newsfeed.R
import com.osmi.newsfeed.dto.Doc
import com.osmi.newsfeed.dto.Multimedia
import com.squareup.picasso.Picasso

class ArticlesHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder
        (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)) {

    companion object {
        const val BASE_IMAGE_URL = "https://static01.nyt.com/"
    }
    private var headline: TextView = itemView.findViewById(R.id.headline)
    private var content: TextView = itemView.findViewById(R.id.content)
    private var author: TextView = itemView.findViewById(R.id.author)
    private var image: ImageView = itemView.findViewById(R.id.articleImage)

    fun bind(doc: Doc) {
        headline.text = doc.headline.main
        content.text = doc.lead_paragraph
        author.text = doc.byline.original

        if (doc.multimedia.isNotEmpty()) {
            val img: Multimedia = doc.multimedia.single {
                it.subtype == "xlarge"
            }


            if (img != null) {
                Picasso.get().load(BASE_IMAGE_URL + img.url)
                    .into(image)
            }
        }
    }
}