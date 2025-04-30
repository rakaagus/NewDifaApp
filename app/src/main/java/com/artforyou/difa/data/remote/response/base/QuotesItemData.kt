package com.artforyou.difa.data.remote.response.base

import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_ID
import com.artforyou.difa.utils.KEY_SOURCE_QUOTE
import com.artforyou.difa.utils.KEY_TEXT_QUOTE
import com.google.gson.annotations.SerializedName

data class QuotesItemData(
    @SerializedName(KEY_CREATE_AT) val createdAt: String = "",
    @SerializedName(KEY_ID) val id: Int = 0,
    @SerializedName(KEY_TEXT_QUOTE) val text: String = "",
    @field:SerializedName(KEY_SOURCE_QUOTE) val source: String = ""
)
