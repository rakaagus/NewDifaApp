package com.artforyou.difa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ArticleModel(
    val id: Int,
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val urlImage: String,
    val image: String,
    val author: String,
    val publishAt: String,
    val createAt: String
) : Parcelable