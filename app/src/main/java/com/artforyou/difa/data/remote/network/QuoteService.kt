package com.artforyou.difa.data.remote.network

import com.artforyou.difa.data.remote.response.QuotesResponse
import retrofit2.http.GET

interface QuoteService {
    @GET("/quotes")
    suspend fun getListQuotes() : QuotesResponse
}