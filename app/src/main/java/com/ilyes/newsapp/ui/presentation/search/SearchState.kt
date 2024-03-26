package com.ilyes.newsapp.ui.presentation.search

import androidx.paging.PagingData
import com.ilyes.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
   val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)