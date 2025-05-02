package com.artforyou.difa.data.remote

import android.util.Log
import com.artforyou.difa.data.remote.network.ApiResponse
import com.artforyou.difa.data.remote.network.ArticleService
import com.artforyou.difa.data.remote.network.QuoteService
import com.artforyou.difa.data.remote.network.RecommendationService
import com.artforyou.difa.data.remote.response.base.ArticleItemData
import com.artforyou.difa.data.remote.response.base.QuotesItemData
import com.artforyou.difa.data.remote.response.base.RecommendationItemData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val articleService: ArticleService,
    private val quoteService: QuoteService,
    private val recommendationService: RecommendationService
){
    fun getAllArticle(): Flow<ApiResponse<List<ArticleItemData>>> {
        return flow {
            try {
                val response = articleService.getListArticle()
                val error = response.error
                val message = response.message
                val data = response.data
                if(!error) {
                    emit(ApiResponse.Success(data))
                } else if(data.isEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Error(message))
                    Log.e("RemoteDataSource", "getAllArticle: $message")
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", "getAllArticle: ${e.toString()}")
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getAllQuotes(): Flow<ApiResponse<List<QuotesItemData>>> {
        return flow {
            try {
                val response = quoteService.getListQuotes()
                val error = response.error
                val message = response.message
                if (!error) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Error(message))
                    Log.e("RemoteDataSource", "getAllQuotes: $message")
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", "getAllQuotes: ${e.toString()}")
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getAllRecommendation(): Flow<ApiResponse<List<RecommendationItemData>>> {
        return flow {
            try {
                val response = recommendationService.getListRecommendation()
                val error = response.error
                val message = response.message
                val data = response.data
                if(!error) {
                    emit(ApiResponse.Success(data))
                } else if(data.isEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Error(message))
                    Log.e("RemoteDataSource", "getAllRecommendation: $message")
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", "getAllRecommendation: ${e.toString()}")
            }
        }.flowOn(Dispatchers.IO)
    }
}