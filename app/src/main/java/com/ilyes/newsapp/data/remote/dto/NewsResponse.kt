package com.ilyes.newsapp.data.remote.dto

import com.ilyes.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)