package com.osmi.newsfeed.data.api.response

import com.osmi.newsfeed.dto.Doc
import com.osmi.newsfeed.dto.Meta

data class ArticlesResponse(val docs: ArrayList<Doc>, val meta: Meta)

data class GeneralArticleResponse(val status: String, val copyright: String, val response: ArticlesResponse)