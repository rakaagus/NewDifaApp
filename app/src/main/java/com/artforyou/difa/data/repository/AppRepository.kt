package com.artforyou.difa.data.repository

import com.artforyou.difa.data.Resource
import com.artforyou.difa.data.local.LocalDataSource
import com.artforyou.difa.data.local.entity.ArticleEntity
import com.artforyou.difa.data.local.entity.QuotesEntity
import com.artforyou.difa.data.local.entity.RecommendationEntity
import com.artforyou.difa.data.remote.RemoteDataSource
import com.artforyou.difa.domain.model.ArticleModel
import com.artforyou.difa.domain.model.QuoteModel
import com.artforyou.difa.domain.model.RecommendationModel
import com.artforyou.difa.domain.repository.IAppRepository
import com.artforyou.difa.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutors,
) : IAppRepository{
    override fun getListArticle(): Flow<Resource<List<ArticleModel>>> {
        TODO("Not yet implemented")
    }

    override fun getListQuotes(): Flow<Resource<List<QuoteModel>>> {
        TODO("Not yet implemented")
    }

    override fun getListRecommendation(): Flow<Resource<List<RecommendationModel>>> {
        TODO("Not yet implemented")
    }

    override fun insertDataArticle(articles: List<ArticleEntity>) {
        TODO("Not yet implemented")
    }

    override fun insertDataQuote(quotes: List<QuotesEntity>) {
        TODO("Not yet implemented")
    }

    override fun insertDataRecommendation(recommendations: List<RecommendationEntity>) {
        TODO("Not yet implemented")
    }

    override fun getArticleById(articleId: Int): Flow<ArticleModel> {
        TODO("Not yet implemented")
    }

    override fun getRecommendationById(recommendationId: Int): Flow<RecommendationModel> {
        TODO("Not yet implemented")
    }

    override fun deleteDataArticle(articleModel: ArticleModel) {
        TODO("Not yet implemented")
    }

    override fun deleteDataQuote(quoteModel: QuoteModel) {
        TODO("Not yet implemented")
    }

    override fun deleteDataRecommendation(recommendationModel: RecommendationModel) {
        TODO("Not yet implemented")
    }
}