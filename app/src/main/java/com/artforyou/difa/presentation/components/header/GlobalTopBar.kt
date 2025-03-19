package com.artforyou.difa.presentation.components.header

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.artforyou.difa.R
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlobalTopBar(
    pageTitle: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = pageTitle,
                color = Color.Black,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackPressed,
                colors = IconButtonDefaults.iconButtonColors(containerColor = blueLight),
                enabled = true
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_left_24),
                    tint = activeTextBlue,
                    contentDescription = stringResource(R.string.back_button_icon_description)
                )
            }
        },
        modifier = modifier
    )
}