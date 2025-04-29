package com.artforyou.difa.data.remote.network

import com.artforyou.difa.data.remote.response.RecommendationResponse
import com.artforyou.difa.utils.KEY_ID
import retrofit2.http.GET
import retrofit2.http.Path

interface RecommendationService {
    @GET("/recommendation")
    suspend fun getListRecommendation() : RecommendationResponse

    @GET("/recommendation/{id}")
    suspend fun getArticleById(
        @Path(KEY_ID) id: Int
    ): RecommendationResponse
}