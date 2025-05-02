package com.artforyou.difa.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artforyou.difa.data.local.entity.QuotesEntity
import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_ENTITY_QUOTE
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDao {

    @Query("SELECT * FROM $KEY_ENTITY_QUOTE ORDER BY $KEY_CREATE_AT ASC")
    fun getAllQuotes(): Flow<List<QuotesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(article: List<QuotesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateQuote(quotesEntity: QuotesEntity)

    @Query("SELECT * FROM $KEY_ENTITY_QUOTE WHERE id = :id ORDER BY $KEY_CREATE_AT ASC")
    fun getQuoteById(id: Int): Flow<QuotesEntity>

    @Delete
    fun deleteQuote(quote: QuotesEntity)

}