package com.artforyou.difa.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_DESCRIPTION
import com.artforyou.difa.utils.KEY_ENTITY_RECOMMENDATION
import com.artforyou.difa.utils.KEY_LINK
import com.artforyou.difa.utils.KEY_TITLE
import com.artforyou.difa.utils.KEY_URL_IMAGE

@Entity(tableName = KEY_ENTITY_RECOMMENDATION)
data class RecommendationEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = KEY_TITLE) val title: String,
    @ColumnInfo(name = KEY_DESCRIPTION) val description: String,
    @ColumnInfo(name = KEY_URL_IMAGE) val urlImage: String,
    @ColumnInfo(name = KEY_LINK) val link: String,
    @ColumnInfo(name = KEY_CREATE_AT) val createAt: String
)