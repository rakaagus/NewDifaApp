package com.artforyou.difa.data.repository

import com.artforyou.difa.data.NetworkBoundResource
import com.artforyou.difa.data.Resource
import com.artforyou.difa.data.local.LocalDataSource
import com.artforyou.difa.data.remote.RemoteDataSource
import com.artforyou.difa.data.remote.network.ApiResponse
import com.artforyou.difa.data.remote.response.base.ArticleItemData
import com.artforyou.difa.data.remote.response.base.QuotesItemData
import com.artforyou.difa.data.remote.response.base.RecommendationItemData
import com.artforyou.difa.domain.model.ArticleModel
import com.artforyou.difa.domain.model.QuoteModel
import com.artforyou.difa.domain.model.RecommendationModel
import com.artforyou.difa.domain.repository.IAppRepository
import com.artforyou.difa.utils.AppExecutors
import com.artforyou.difa.utils.mapper.ArticleMapper
import com.artforyou.difa.utils.mapper.QuoteMapper
import com.artforyou.difa.utils.mapper.RecommendationMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutors,
) : IAppRepository{
    override fun getListArticle(): Flow<Resource<List<ArticleModel>>> =
        object : NetworkBoundResource<List<ArticleModel>, List<ArticleItemData>>(){
            override fun loadFromDB(): Flow<List<ArticleModel>> {
                return localDataSource.getAllArticleCacheData().map {
                    ArticleMapper.articleEntitiesToModelMapper(it)
                }
            }

            override fun shouldFetch(data: List<ArticleModel>?): Boolean =
                data.isNullOrEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<ArticleItemData>>> =
                remoteDataSource.getAllArticle()

            override suspend fun saveCallResult(data: List<ArticleItemData>) {
                val articleList = ArticleMapper.articleResponseToEntitiesMapper(data)
                localDataSource.insertDataArticle(articleList)
            }
        }.asFlow()

    override fun getListQuotes(): Flow<Resource<List<QuoteModel>>> =
        object: NetworkBoundResource<List<QuoteModel>, List<QuotesItemData>>() {
            override fun loadFromDB(): Flow<List<QuoteModel>> {
                return localDataSource.getAllQuotesCacheData().map {
                    QuoteMapper.quoteEntitiesToModelMapper(it)
                }
            }

            override fun shouldFetch(data: List<QuoteModel>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<QuotesItemData>>> =
                remoteDataSource.getAllQuotes()

            override suspend fun saveCallResult(data: List<QuotesItemData>) {
                val quotesList = QuoteMapper.quoteResponseToEntitiesMapper(data)
                localDataSource.insertQuotes(quotesList)
            }

        }.asFlow()

    override fun getListRecommendation(): Flow<Resource<List<RecommendationModel>>> =
        object : NetworkBoundResource<List<RecommendationModel>, List<RecommendationItemData>>() {
            override fun loadFromDB(): Flow<List<RecommendationModel>> {
                return localDataSource.getAllRecommendationCacheData().map {
                    RecommendationMapper.recommendationEntitiesToModelMapper(it)
                }
            }

            override fun shouldFetch(data: List<RecommendationModel>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<RecommendationItemData>>> =
                remoteDataSource.getAllRecommendation()

            override suspend fun saveCallResult(data: List<RecommendationItemData>) {
                val recommendationList = RecommendationMapper.recommendationResponseToEntitiesMapper(data)
                localDataSource.insertRecommendation(recommendationList)
            }

        }.asFlow()


    override fun getArticleById(articleId: Int): Flow<ArticleModel> =
        localDataSource.getDetailArticleCacheData(articleId).map {
            ArticleMapper.recommendationEntitiesToModelMapper(it)
        }

    override fun getRecommendationById(recommendationId: Int): Flow<RecommendationModel> =
        localDataSource.getDetailRecommendationCacheData(recommendationId).map {
            RecommendationMapper.recommendationEntitiesToModelMapper(it)
        }

    override fun deleteDataArticle(articleModel: ArticleModel) {
        val article = ArticleMapper.articleModelToEntitiesMapper(articleModel)
        appExecutor.diskIO().execute { localDataSource.getDeleteArticle(article) }
    }

    override fun deleteDataQuote(quoteModel: QuoteModel) {
        val quote = QuoteMapper.quoteModelToEntitiesMapper(quoteModel)
        appExecutor.diskIO().execute { localDataSource.getDeleteQuote(quote) }
    }

    override fun deleteDataRecommendation(recommendationModel: RecommendationModel) {
        val recommendation = RecommendationMapper.recommendationModelToEntitiesMapper(recommendationModel)
        appExecutor.diskIO().execute { localDataSource.getDeleteRecommendation(recommendation) }
    }
}