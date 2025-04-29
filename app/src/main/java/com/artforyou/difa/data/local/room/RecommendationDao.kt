package com.artforyou.difa.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artforyou.difa.data.local.entity.RecommendationEntity
import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_ENTITY_RECOMMENDATION

@Dao
interface RecommendationDao {

    @Query("SELECT * FROM $KEY_ENTITY_RECOMMENDATION ORDER BY $KEY_CREATE_AT ASC")
    fun getAllRecommendations(): LiveData<List<RecommendationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecommendations(recommendationEntity: List<RecommendationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateRecommendation(recommendation: RecommendationEntity)

    @Query("SELECT * FROM $KEY_ENTITY_RECOMMENDATION WHERE id = :id ORDER BY $KEY_CREATE_AT ASC")
    fun getQuoteById(id: Int): LiveData<RecommendationEntity>

    @Delete
    fun deleteRecommendation(recommendation: RecommendationEntity)

}