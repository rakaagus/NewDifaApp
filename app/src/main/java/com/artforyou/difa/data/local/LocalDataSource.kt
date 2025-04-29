package com.artforyou.difa.data.local

import com.artforyou.difa.data.local.room.ArticleDao
import com.artforyou.difa.data.local.room.QuotesDao
import com.artforyou.difa.data.local.room.RecommendationDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject
constructor(
    private val articleDao: ArticleDao,
    private val quoteDao: QuotesDao,
    private val recommendationDao: RecommendationDao
) {
}