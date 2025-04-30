package com.artforyou.difa.data.remote.response.base

import com.artforyou.difa.utils.KEY_AUTHOR
import com.artforyou.difa.utils.KEY_CONTENT
import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_DESCRIPTION
import com.artforyou.difa.utils.KEY_ID
import com.artforyou.difa.utils.KEY_IMAGE
import com.artforyou.difa.utils.KEY_PUBLISH_AT
import com.artforyou.difa.utils.KEY_TITLE
import com.artforyou.difa.utils.KEY_URL
import com.artforyou.difa.utils.KEY_URL_IMAGE
import com.google.gson.annotations.SerializedName

data class ArticleItemData(
    @SerializedName(KEY_IMAGE) val image: String = "",
    @SerializedName(KEY_CREATE_AT) val createdAt: String = "",
    @SerializedName(KEY_AUTHOR) val author: String = "",
    @SerializedName(KEY_DESCRIPTION) val description: String = "",
    @SerializedName(KEY_ID) val id: Int = 0,
    @SerializedName(KEY_TITLE) val title: String = "",
    @SerializedName(KEY_PUBLISH_AT) val publishedAt: String = "",
    @SerializedName(KEY_CONTENT) val content: String = "",
    @SerializedName(KEY_URL) val url: String = "",
    @SerializedName(KEY_URL_IMAGE) val urlImage: String = ""
)
