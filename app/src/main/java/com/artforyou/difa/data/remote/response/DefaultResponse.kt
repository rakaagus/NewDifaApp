package com.artforyou.difa.data.remote.response

import com.artforyou.difa.utils.KEY_DATA
import com.artforyou.difa.utils.KEY_ERROR
import com.artforyou.difa.utils.KEY_MESSAGE
import com.google.gson.annotations.SerializedName

data class DefaultResponse<DATA> (
    @SerializedName(KEY_DATA) val data: DATA,
    @SerializedName(KEY_ERROR) val error: Boolean = false,
    @SerializedName(KEY_MESSAGE) val message: String = ""
)