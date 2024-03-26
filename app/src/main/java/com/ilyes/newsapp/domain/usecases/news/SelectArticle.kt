package com.ilyes.newsapp.domain.usecases.news

import com.ilyes.newsapp.data.local.NewsDao
import com.ilyes.newsapp.domain.model.Article
import com.ilyes.newsapp.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository

) {

    suspend operator fun invoke(url: String): Article?{
        return newsRepository.selectArticle(url)
    }

}