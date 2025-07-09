package com.artforyou.difa.presentation.components.header

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.ui.theme.PurpleMainColor
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlobalTopBar(
    modifier: Modifier = Modifier,
    pageTitle: String,
    onBackPressed: () -> Unit,
    actionIcon: (@Composable () -> Unit)? = null,
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = PurpleMainColor),
        title = {
            Text(
                text = pageTitle,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackPressed,
                enabled = true,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(40.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_left_24),
                    tint = Color.White,
                    contentDescription = stringResource(R.string.back_button_icon_description),
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        actions = {
            actionIcon?.let { it() }
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun GlobalTopBar() {
    GlobalTopBar(
        pageTitle = "Home",
        onBackPressed = {},
        actionIcon = {}
    )
}