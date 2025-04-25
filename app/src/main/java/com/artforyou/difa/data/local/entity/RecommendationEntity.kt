package com.artforyou.difa.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artforyou.difa.utils.KEY_ENTITY_RECOMMENDATION

@Entity(tableName = KEY_ENTITY_RECOMMENDATION)
data class RecommendationEntity (
    @PrimaryKey(autoGenerate = true) val id: Int
)