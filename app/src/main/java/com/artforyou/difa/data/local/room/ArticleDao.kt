package com.artforyou.difa.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artforyou.difa.data.local.entity.ArticleEntity
import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_ENTITY_ARTICLE
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM $KEY_ENTITY_ARTICLE ORDER BY $KEY_CREATE_AT ASC")
    fun getAllArticle(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: List<ArticleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateArticle(articleEntity: ArticleEntity)

    @Query("SELECT * FROM $KEY_ENTITY_ARTICLE WHERE id = :id ORDER BY $KEY_CREATE_AT ASC")
    fun getArticleById(id: Int): Flow<ArticleEntity>

    @Delete
    fun deleteArticle(article: ArticleEntity)

}