package com.ilyes.newsapp.ui.presentation.bookmark

import com.ilyes.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
