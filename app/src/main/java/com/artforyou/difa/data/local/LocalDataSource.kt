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
    // Article
    fun getAllArticleCacheData(): Flow<List<ArticleEntity>> = articleDao.getAllArticle()
    suspend fun insertDataArticle(list: List<ArticleEntity>) = articleDao.insertArticle(list)
    fun getDetailArticleCacheData(articleId: Int) : Flow<ArticleEntity> = articleDao.getArticleById(articleId)
    fun getDeleteArticle(articleEntity: ArticleEntity) = articleDao.deleteArticle(articleEntity)

    // Quotes
    fun getAllQuotesCacheData(): Flow<List<QuotesEntity>> = quoteDao.getAllQuotes()
    suspend fun insertQuotes(list: List<QuotesEntity>) = quoteDao.insertQuote(list)
    fun getDeleteQuote(quotesEntity: QuotesEntity) = quoteDao.deleteQuote(quotesEntity)

    // Recommendation
    fun getAllRecommendationCacheData(): Flow<List<RecommendationEntity>> = recommendationDao.getAllRecommendations()
    suspend fun insertRecommendation(list: List<RecommendationEntity>) = recommendationDao.insertRecommendations(list)
    fun getDetailRecommendationCacheData(recommendationId: Int) : Flow<RecommendationEntity> = recommendationDao.getRecommendationById(recommendationId)
    fun getDeleteRecommendation(recommendationEntity: RecommendationEntity) = recommendationDao.deleteRecommendation(recommendationEntity)
}