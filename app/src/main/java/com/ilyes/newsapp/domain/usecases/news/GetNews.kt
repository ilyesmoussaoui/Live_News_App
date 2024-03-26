package com.ilyes.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.ilyes.newsapp.domain.model.Article
import com.ilyes.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources:List<String>):Flow<PagingData<Article>> {


        return newsRepository.getNews(sources = sources)
    }
}