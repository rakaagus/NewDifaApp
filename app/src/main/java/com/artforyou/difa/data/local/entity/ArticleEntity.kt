package com.artforyou.difa.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.artforyou.difa.utils.KEY_AUTHOR
import com.artforyou.difa.utils.KEY_CONTENT
import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_DESCRIPTION
import com.artforyou.difa.utils.KEY_ENTITY_ARTICLE
import com.artforyou.difa.utils.KEY_IMAGE
import com.artforyou.difa.utils.KEY_PUBLISH_AT
import com.artforyou.difa.utils.KEY_TITLE
import com.artforyou.difa.utils.KEY_URL
import com.artforyou.difa.utils.KEY_URL_IMAGE

@Entity(tableName = KEY_ENTITY_ARTICLE)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = KEY_TITLE) val title: String,
    @ColumnInfo(name = KEY_CONTENT) val content: String,
    @ColumnInfo(name = KEY_DESCRIPTION) val description: String,
    @ColumnInfo(name = KEY_AUTHOR) val author: String,
    @ColumnInfo(name = KEY_URL) val url: String,
    @ColumnInfo(name = KEY_URL_IMAGE) val urlImage: String,
    @ColumnInfo(name = KEY_IMAGE) val image: String,
    @ColumnInfo(name = KEY_PUBLISH_AT) val publishAt: String,
    @ColumnInfo(name = KEY_CREATE_AT) val createAt: String
)