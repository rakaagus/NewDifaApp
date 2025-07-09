package com.artforyou.difa.presentation.screen.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.SetStatusBarColor
import com.artforyou.difa.presentation.components.header.GlobalTopBar
import com.artforyou.difa.presentation.screen.about.component.AboutDropDown
import com.artforyou.difa.ui.theme.Gray100

@Composable
fun AboutScreen(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    SetStatusBarColor(color = Color.White)
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Gray100,
        topBar = {
            GlobalTopBar(
                pageTitle = stringResource(R.string.text_about),
                onBackPressed = onBackPressed
            )
        }
    ) { paddingValues ->
        AboutContent(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun AboutContent(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier.fillMaxSize().padding(top = 20.dp)
    ) {
        AboutDropDown(
            title = stringResource(R.string.title_about_1),
            description = stringResource(R.string.description_about_1)
        )
        AboutDropDown(
            title = stringResource(R.string.title_about_2),
            description = stringResource(R.string.description_about_2)
        )
        AboutDropDown(
            title = stringResource(R.string.title_about_3),
            description = stringResource(R.string.description_about_3)
        )
        AboutDropDown(
            title = stringResource(R.string.title_about_4),
            description = stringResource(R.string.description_about_4)
        )
    }
}

@Preview
@Composable
private fun AboutScreenPrev() {
    AboutScreen(
        onBackPressed = {}
    )
}