package com.ilyes.newsapp.di

import android.app.Application
import androidx.room.Room
import com.ilyes.newsapp.data.local.NewsDao
import com.ilyes.newsapp.data.local.NewsDatabase
import com.ilyes.newsapp.data.local.NewsTypeConvertor
import com.ilyes.newsapp.data.manager.LocalUserManagerImp
import com.ilyes.newsapp.data.remote.NewsApi
import com.ilyes.newsapp.data.repository.NewsRepositoryImp
import com.ilyes.newsapp.domain.manager.LocalUserManager
import com.ilyes.newsapp.domain.repository.NewsRepository
import com.ilyes.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.ilyes.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.ilyes.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.ilyes.newsapp.domain.usecases.news.DeleteArticle
import com.ilyes.newsapp.domain.usecases.news.GetNews
import com.ilyes.newsapp.domain.usecases.news.NewsUseCases
import com.ilyes.newsapp.domain.usecases.news.SearchNews
import com.ilyes.newsapp.domain.usecases.news.SelectArticle
import com.ilyes.newsapp.domain.usecases.news.SelectArticles
import com.ilyes.newsapp.domain.usecases.news.UpsertArticle
import com.ilyes.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object Module {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImp(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ):NewsRepository = NewsRepositoryImp(newsApi, newsDao)




    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
    ):NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }
    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}