package com.artforyou.difa.presentation.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.presentation.navigation.Dest
import com.artforyou.difa.presentation.screen.onboarding.component.OnBoardingTextButton

@Composable
fun GetStartedScreen(
    moveToHome: () -> Unit,
    modifier: Modifier = Modifier,
){
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
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
    Box (modifier = modifier.fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.img_getstarted),
            contentDescription = "Logo",
            modifier = Modifier
                .size(350.dp)
                .align(Alignment.Center)
        )

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(id = R.string.get_started_title),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 35.dp)
            )
            Spacer(Modifier.height(20.dp))
            OnBoardingTextButton(title = "Get Started", moveTo = moveToHome)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun GetStartedScreenPrev() {
    GetStartedContent(
        moveToHome = {}
    )
}