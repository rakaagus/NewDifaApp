package com.artforyou.difa.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artforyou.difa.utils.KEY_ENTITY_ARTICLE

@Entity(tableName = KEY_ENTITY_ARTICLE)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int
)