package com.artforyou.difa.data.remote

import com.artforyou.difa.data.remote.network.ArticleService
import com.artforyou.difa.data.remote.network.QuoteService
import com.artforyou.difa.data.remote.network.RecommendationService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val articleService: ArticleService,
    private val quoteService: QuoteService,
    private val recommendationService: RecommendationService
){
}