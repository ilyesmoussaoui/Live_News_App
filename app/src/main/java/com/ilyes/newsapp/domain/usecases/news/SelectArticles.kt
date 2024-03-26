package com.ilyes.newsapp.domain.usecases.news

import com.ilyes.newsapp.data.local.NewsDao
import com.ilyes.newsapp.domain.model.Article
import com.ilyes.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }

}