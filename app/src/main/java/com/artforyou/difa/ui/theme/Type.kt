package com.artforyou.difa.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.artforyou.difa.R

val Poppins = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Poppins
    ),
    headlineMedium = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Poppins
    ),
    headlineSmall = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Poppins
    ),
    bodyLarge = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Poppins
    ),
    bodyMedium = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Poppins
    ),
    bodySmall = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Poppins
    ),
    labelLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Poppins
    ),
    labelMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Poppins
    ),
    labelSmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Poppins
    ),
)