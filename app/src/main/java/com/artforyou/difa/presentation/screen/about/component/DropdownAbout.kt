package com.artforyou.difa.presentation.screen.about.component

import android.R
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.ui.theme.Gray200
import com.artforyou.difa.ui.theme.blueLight

@Composable
fun AboutDropDown(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
   var isExpanded by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(3.dp, Gray200, shape = MaterialTheme.shapes.small)
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        Column(
            modifier = Modifier.padding(30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Black,
                    modifier = modifier.weight(1f)
                )
                Icon(
                    imageVector = if (isExpanded)Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }

            AnimatedVisibility(visible = isExpanded) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun AboutDropDownPrev() {
    AboutDropDown(
        title = "Apa Itu Difa?",
        description = "Aplikasi DIFA adalah solusi inovatif yang memanfaatkan teknologi kecerdasan buatan (AI) dan pengenalan gambar untuk mengenali serta menerjemahkan Bahasa Isyarat"
    )
}