package com.artforyou.difa.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.artforyou.difa.data.local.entity.ArticleEntity
import com.artforyou.difa.data.local.entity.QuotesEntity
import com.artforyou.difa.data.local.entity.RecommendationEntity

@Database(
    entities = [ArticleEntity::class, RecommendationEntity::class, QuotesEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao() : ArticleDao

    abstract fun recommendationDao(): RecommendationDao

    abstract fun quotesDao(): QuotesDao
}