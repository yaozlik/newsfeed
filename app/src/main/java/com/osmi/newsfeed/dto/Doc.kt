package com.osmi.newsfeed.dto

data class Doc(val web_url: String,
               val lead_paragraph: String,
               val source: String,
               val type_of_material: String,
               val pub_date: String,
               val section_name: String,
               val subsectoinName: String,
               val multimedia: List<Multimedia>,
               val byline: Author,
               val headline: HeadLine)