package com.artforyou.difa.presentation.screen.onboarding

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GetStartedScreen(
    moveToHome: () -> Unit,
    modifier: Modifier,
){
    Scaffold { paddingValues ->
        GetStartedContent(
            moveToHome = moveToHome,
            modifier = modifier.padding(paddingValues)
        )
    }
}

@Composable
fun GetStartedContent(
    moveToHome: () -> Unit,
    modifier: Modifier = Modifier
){
    
}