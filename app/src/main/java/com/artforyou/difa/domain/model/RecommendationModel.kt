package com.artforyou.difa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecommendationModel(
    val int: Int,
    val title: String,
    val description: String,
    val urlImage: String,
    val link: String,
    val createAt: String
): Parcelable