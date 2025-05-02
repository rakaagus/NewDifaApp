package com.artforyou.difa.domain.usecase

import com.artforyou.difa.data.Resource
import com.artforyou.difa.data.local.entity.ArticleEntity
import com.artforyou.difa.data.local.entity.QuotesEntity
import com.artforyou.difa.data.local.entity.RecommendationEntity
import com.artforyou.difa.domain.model.ArticleModel
import com.artforyou.difa.domain.model.QuoteModel
import com.artforyou.difa.domain.model.RecommendationModel
import com.artforyou.difa.domain.repository.IAppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppInteractor @Inject
constructor(
    private val appRepository: IAppRepository
): AppUseCase{
    override fun getListArticle(): Flow<Resource<List<ArticleModel>>> = appRepository.getListArticle()

    override fun getListQuotes(): Flow<Resource<List<QuoteModel>>> = appRepository.getListQuotes()

    override fun getListRecommendation(): Flow<Resource<List<RecommendationModel>>> = appRepository.getListRecommendation()

    override fun getArticleById(articleId: Int): Flow<ArticleModel> = appRepository.getArticleById(articleId)

    override fun getRecommendationById(recommendationId: Int): Flow<RecommendationModel> = appRepository.getRecommendationById(recommendationId)

    override fun deleteDataArticle(articleModel: ArticleModel) = appRepository.deleteDataArticle(articleModel)

    override fun deleteDataQuote(quoteModel: QuoteModel) = appRepository.deleteDataQuote(quoteModel)

    override fun deleteDataRecommendation(recommendationModel: RecommendationModel) = appRepository.deleteDataRecommendation(recommendationModel)

}