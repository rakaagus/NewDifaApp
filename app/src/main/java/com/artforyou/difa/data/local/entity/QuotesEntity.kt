package com.artforyou.difa.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_ENTITY_QUOTE
import com.artforyou.difa.utils.KEY_SOURCE_QUOTE
import com.artforyou.difa.utils.KEY_TEXT_QUOTE

@Entity(tableName = KEY_ENTITY_QUOTE)
data class QuotesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = KEY_TEXT_QUOTE) val text: String,
    @ColumnInfo(name = KEY_SOURCE_QUOTE) val source: String,
    @ColumnInfo(name = KEY_CREATE_AT) val createAt: String,
)
