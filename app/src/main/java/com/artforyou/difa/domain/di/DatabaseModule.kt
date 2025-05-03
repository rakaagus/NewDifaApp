package com.artforyou.difa.domain.di

import android.content.Context
import androidx.room.Room
import com.artforyou.difa.data.local.room.AppDatabase
import com.artforyou.difa.data.local.room.ArticleDao
import com.artforyou.difa.data.local.room.QuotesDao
import com.artforyou.difa.data.local.room.RecommendationDao
import com.artforyou.difa.data.local.shered.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "App.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideArticleDao(database: AppDatabase): ArticleDao = database.articleDao()

    @Provides
    fun provideRecommendationDao(database: AppDatabase): RecommendationDao = database.recommendationDao()

    @Provides
    fun provideQuoteDao(database: AppDatabase): QuotesDao = database.quotesDao()

    @Provides
    fun provideAppPreferences(@ApplicationContext context: Context): AppPreferences =
        AppPreferences(context)
}