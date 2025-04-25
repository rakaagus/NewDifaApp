package com.artforyou.difa.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artforyou.difa.utils.KEY_ENTITY_QUOTE

@Entity(tableName = KEY_ENTITY_QUOTE)
data class QuotesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int
)
