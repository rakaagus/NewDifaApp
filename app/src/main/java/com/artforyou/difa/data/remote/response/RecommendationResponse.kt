package com.artforyou.difa.data.remote.response

import com.artforyou.difa.utils.KEY_CREATE_AT
import com.artforyou.difa.utils.KEY_DESCRIPTION
import com.artforyou.difa.utils.KEY_ID
import com.artforyou.difa.utils.KEY_LINK
import com.artforyou.difa.utils.KEY_RESPONSE
import com.artforyou.difa.utils.KEY_TITLE
import com.artforyou.difa.utils.KEY_URL_IMAGE
import com.google.gson.annotations.SerializedName

data class RecommendationResponse(
	@SerializedName(KEY_RESPONSE) val response: DefaultResponse<RecommendationItemData>
)

data class RecommendationItemData(
	@SerializedName(KEY_CREATE_AT) val createdAt: String = "",
	@SerializedName(KEY_LINK) val link: String = "",
	@SerializedName(KEY_DESCRIPTION) val description: String = "",
	@SerializedName(KEY_ID) val id: Int = 0,
	@SerializedName(KEY_TITLE) val title: String = "",
	@SerializedName(KEY_URL_IMAGE) val urlImage: String = ""
)
