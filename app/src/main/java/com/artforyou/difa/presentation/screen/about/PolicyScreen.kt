package com.artforyou.difa.presentation.screen.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.SetStatusBarColor
import com.artforyou.difa.presentation.components.header.GlobalTopBar
import com.artforyou.difa.ui.theme.Gray100

@Composable
fun PolicyScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
){
    SetStatusBarColor(color = Color.White)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Gray100,
        topBar = {
            GlobalTopBar(
                pageTitle = stringResource(R.string.text_policy),
                onBackPressed = onBackPressed,
            )
        }
    ) { paddingValues ->
        PolicyScreenContent(
            modifier = modifier.padding(paddingValues)
        )
    }
}

@Composable
fun PolicyScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        SimpleFormatText(
            text1 = {
                Text(
                    text = stringResource(R.string.policy_desc),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            text2 = {
                Text(
                    text = stringResource(R.string.policy_point),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        )
        SimpleFormatText(
            text1 = {
                Text(
                    text = stringResource(R.string.text_point_1),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            text2 = {
                Text(
                    text = stringResource(R.string.text_point_1_desc),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 15.dp)
        )
        SimpleFormatText(
            text1 = {
                Text(
                    text = stringResource(R.string.text_point_2),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            text2 = {
                Text(
                    text = stringResource(R.string.text_point_2_desc),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 15.dp)
        )
        SimpleFormatText(
            text1 = {
                Text(
                    text = stringResource(R.string.text_point_3),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            text2 = {
                Text(
                    text = stringResource(R.string.text_point_3_desc),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 15.dp)
        )
        SimpleFormatText(
            text1 = {
                Text(
                    text = stringResource(R.string.text_point_4),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            text2 = {
                Text(
                    text = stringResource(R.string.text_point_4_desc),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 15.dp)
        )
        SimpleFormatText(
            text1 = {
                Text(
                    text = stringResource(R.string.text_point_5),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            text2 = {
                Text(
                    text = stringResource(R.string.text_point_5_desc),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 15.dp)
        )
    }
}

@Composable
fun SimpleFormatText(
    modifier: Modifier = Modifier,
    text1: @Composable () -> Unit,
    text2: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        text1()
        Spacer(Modifier.height(10.dp))
        text2()
    }
}

@Preview
@Composable
private fun PolicyScreenPreview() {
    PolicyScreen(
        onBackPressed = {}
    )
}