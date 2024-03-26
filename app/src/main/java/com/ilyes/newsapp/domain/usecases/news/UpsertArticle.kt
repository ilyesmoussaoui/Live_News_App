package com.ilyes.newsapp.domain.usecases.news

import com.ilyes.newsapp.data.local.NewsDao
import com.ilyes.newsapp.domain.model.Article
import com.ilyes.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class UpsertArticle (
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article)
    }

}