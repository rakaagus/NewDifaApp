package com.artforyou.difa.presentation.screen.help

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.artforyou.difa.R
import com.artforyou.difa.SetStatusBarColor
import com.artforyou.difa.presentation.components.header.ComingSoonFeatureImage
import com.artforyou.difa.presentation.components.header.GlobalTopBar
import com.artforyou.difa.ui.theme.PurpleMainColor

@Composable
fun ReportScreen(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    SetStatusBarColor(color = PurpleMainColor)
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            GlobalTopBar(
                pageTitle = stringResource(R.string.text_report_screen),
                onBackPressed = onBackPressed,
            )
        }
    ) { paddingValues ->
       ReportContent(
           onBackPressed = onBackPressed,
           modifier = modifier.padding(paddingValues)
       )
    }
}

@Composable
fun ReportContent(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    ComingSoonFeatureImage(
        onButtonClicked = onBackPressed,
        modifier = modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun ReportScreenPrev() {
    ReportScreen(
        onBackPressed = {}
    )
}