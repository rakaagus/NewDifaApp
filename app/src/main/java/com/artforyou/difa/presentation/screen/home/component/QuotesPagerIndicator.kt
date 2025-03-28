package com.artforyou.difa.presentation.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun QuotesPagerIndicator(
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
                    .background(if (index == activeIndex) activeTextBlue else blueLight)
                    .size(width = 10.dp, height = 10.dp)
            )
        }
    }
}