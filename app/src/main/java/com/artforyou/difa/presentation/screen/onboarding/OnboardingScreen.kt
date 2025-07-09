package com.artforyou.difa.presentation.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.presentation.screen.onboarding.component.OnBoardingTextButton
import com.artforyou.difa.ui.theme.Gray300
import com.artforyou.difa.ui.theme.PurpleMainColor
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight
import com.artforyou.difa.utils.enum.OnboardingPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    moveToGetStarted: () -> Unit
){
    val page = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third
    )

    val pagerState = rememberPagerState(initialPage = 0)

    LaunchedEffect(pagerState.currentPage) {
        delay(3500)
        var newPosition = pagerState.currentPage + 1
        if (newPosition > page.size - 1) newPosition = 0
        pagerState.animateScrollToPage(newPosition)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
        OnBoardingContent(
            modifier = Modifier.padding(paddingValues),
            moveToGetStarted = moveToGetStarted,
            pagerState = pagerState,
            onBoardingList = page
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingContent(
    modifier: Modifier,
    moveToGetStarted: () -> Unit,
    onBoardingList: List<OnboardingPage>,
    pagerState: PagerState
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(10f)
        ) { position ->
            PagerScreen(onboardingPage = onBoardingList[position])
        }
        PagerIndicator(pagerState = pagerState)
        OnBoardingTextButton(
            title = "Continue",
            moveTo = moveToGetStarted
        )
    }
}

@Composable
fun PagerScreen(
    modifier: Modifier = Modifier,
    onboardingPage: OnboardingPage,
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = onboardingPage.image),
            contentDescription = stringResource(R.string.img_onboarding),
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(id = onboardingPage.title),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 35.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = onboardingPage.description),
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Normal
            ),
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 35.dp)
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerIndicator(
    pagerState: PagerState
) {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        val activeIndex = pagerState.currentPage
        repeat(pagerState.pageCount) { index ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (index == activeIndex) PurpleMainColor else Gray300)
                    .size(width = 10.dp, height = 10.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun onBoardingPrev(){
    OnBoardingScreen(
        moveToGetStarted = {}
    )
}