package com.artforyou.difa.data.remote.network

import com.artforyou.difa.data.remote.response.GetAllRecommendationResponse
import com.artforyou.difa.data.remote.response.GetRecommendationResponse
import com.artforyou.difa.utils.KEY_ID
import retrofit2.http.GET
import retrofit2.http.Path

interface RecommendationService {
    @GET("/recommendation")
    suspend fun getListRecommendation() : GetAllRecommendationResponse

    @GET("/recommendation/{id}")
    suspend fun getArticleById(
        @Path(KEY_ID) id: Int
    ): GetRecommendationResponse
}