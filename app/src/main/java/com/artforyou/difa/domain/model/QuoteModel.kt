package com.artforyou.difa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuoteModel(
    val int: Int,
    val text: String,
    val source: String,
    val createAt: String
) : Parcelable