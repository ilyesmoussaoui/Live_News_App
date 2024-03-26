package com.ilyes.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.ilyes.newsapp.domain.model.Article
import com.ilyes.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {



        operator fun invoke(searchQuery: String,sources:List<String>): Flow<PagingData<Article>> {


            return newsRepository.searchNews(searchQuery = searchQuery,sources = sources)
        }
}