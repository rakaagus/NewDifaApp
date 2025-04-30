package com.artforyou.difa.data.local

import com.artforyou.difa.data.local.entity.ArticleEntity
import com.artforyou.difa.data.local.entity.QuotesEntity
import com.artforyou.difa.data.local.entity.RecommendationEntity
import com.artforyou.difa.data.local.room.ArticleDao
import com.artforyou.difa.data.local.room.QuotesDao
import com.artforyou.difa.data.local.room.RecommendationDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject
constructor(
    private val articleDao: ArticleDao,
    private val quoteDao: QuotesDao,
    private val recommendationDao: RecommendationDao
) {
    fun getAllArticleCacheData(): Flow<List<ArticleEntity>> = articleDao.getAllArticle()
    fun getDetailArticleCacheData(articleId: Int) : Flow<ArticleEntity> = articleDao.getArticleById(articleId)
    fun getAllQuotesCacheData(): Flow<List<QuotesEntity>> = quoteDao.getAllQuotes()
    fun getAllRecommendationCacheData(): Flow<List<RecommendationEntity>> = recommendationDao.getAllRecommendations()
    fun getDetailRecommendationCacheData(recommendationId: Int) : Flow<RecommendationEntity> = recommendationDao.getRecommendationById(recommendationId)
}