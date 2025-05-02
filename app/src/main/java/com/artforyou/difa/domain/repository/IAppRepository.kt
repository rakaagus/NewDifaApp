package com.artforyou.difa.domain.repository

import com.artforyou.difa.data.Resource
import com.artforyou.difa.data.local.entity.ArticleEntity
import com.artforyou.difa.data.local.entity.QuotesEntity
import com.artforyou.difa.data.local.entity.RecommendationEntity
import com.artforyou.difa.domain.model.ArticleModel
import com.artforyou.difa.domain.model.QuoteModel
import com.artforyou.difa.domain.model.RecommendationModel
import kotlinx.coroutines.flow.Flow

interface IAppRepository {
    /*Get List All Data*/
    fun getListArticle(): Flow<Resource<List<ArticleModel>>>
    fun getListQuotes(): Flow<Resource<List<QuoteModel>>>
    fun getListRecommendation(): Flow<Resource<List<RecommendationModel>>>

    /*Get One Data*/
    fun getArticleById(articleId: Int): Flow<ArticleModel>
    fun getRecommendationById(recommendationId: Int): Flow<RecommendationModel>

    /*Delete data*/
    fun deleteDataArticle(articleModel: ArticleModel)
    fun deleteDataQuote(quoteModel: QuoteModel)
    fun deleteDataRecommendation(recommendationModel: RecommendationModel)
}