package com.artforyou.difa.presentation.screen.home.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.artforyou.difa.R
import com.artforyou.difa.ui.theme.GreenLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppbar(
    modifier: Modifier = Modifier,
    pageTitle: String = stringResource(R.string.text_home)
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = GreenLight),
        title = {
            Text(
                text = pageTitle,
                color = Color.Black,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun HomeAppBarPrev() {
    HomeAppbar()
}