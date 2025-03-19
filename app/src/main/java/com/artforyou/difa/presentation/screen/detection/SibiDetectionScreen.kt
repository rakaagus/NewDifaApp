package com.artforyou.difa.presentation.screen.detection

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.artforyou.difa.presentation.components.header.GlobalTopBar

@Composable
fun SibiDetectionScreen(){
    Scaffold(
        containerColor = Color.White,
        topBar = {
            GlobalTopBar(
                pageTitle = "Sibi Detection",
                onBackPressed = {}
            )
        }
    ) { paddingValues ->
        SibiDetectionContent(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun SibiDetectionContent(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SibiDetectionScreenPrev() {
    SibiDetectionScreen()
}