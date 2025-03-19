package com.artforyou.difa.presentation.screen.splashscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artforyou.difa.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    moveToOnboarding: () -> Unit,
    modifier: Modifier = Modifier
) {
    var splash by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        delay(500)
        splash = true
        delay(1000)
        moveToOnboarding()
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
        SplashScreenContent(
            state = splash,
            modifier = modifier.padding(paddingValues)
        )
    }
}

@Composable
fun SplashScreenContent(
    state: Boolean,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.difa_logo_2),
            contentDescription = "Logo",
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.Center)
        )

        AnimatedVisibility(
            state,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 24.dp)
        ) {
            Text(
                text = "V2.0",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPrev() {
    SplashScreen(
        moveToOnboarding = {}
    )
}