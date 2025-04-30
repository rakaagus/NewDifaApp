package com.artforyou.difa.data.remote.network

import com.artforyou.difa.data.remote.response.GetAllArticleResponse
import com.artforyou.difa.data.remote.response.GetArticleResponse
import com.artforyou.difa.utils.KEY_ID
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {

    @GET("/article")
    suspend fun getListArticle() : GetAllArticleResponse

    @GET("/article/{id}")
    suspend fun getArticleById(
        @Path(KEY_ID) id: Int
    ): GetArticleResponse
}