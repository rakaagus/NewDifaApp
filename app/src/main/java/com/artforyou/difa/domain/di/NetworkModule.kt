package com.artforyou.difa.domain.di


import com.artforyou.difa.BuildConfig
import com.artforyou.difa.data.remote.network.ArticleService
import com.artforyou.difa.data.remote.network.QuoteService
import com.artforyou.difa.data.remote.network.RecommendationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
       return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideArticleService(retrofit: Retrofit): ArticleService {
        return retrofit.create(ArticleService::class.java)
    }

    @Provides
    fun provideQuotesService(retrofit: Retrofit): QuoteService {
        return retrofit.create(QuoteService::class.java)
    }

    @Provides
    fun provideRecommendationService(retrofit: Retrofit): RecommendationService {
        return retrofit.create(RecommendationService::class.java)
    }
}