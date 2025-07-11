package com.artforyou.difa.presentation.screen.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.domain.model.QuoteModel
import com.artforyou.difa.ui.theme.PurpleMainColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun QuotesPager(
    quotes: List<QuoteModel>,
    modifier: Modifier = Modifier
) {

    val listQuotes = quotes.take(5)

    val pagerState = rememberPagerState(initialPage = 0)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = listQuotes.size,
            state = pagerState,
            itemSpacing = 10.dp
        ) { pager ->
            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(3.dp, PurpleMainColor, shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = listQuotes[pager].text,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp).fillMaxSize()
                )
            }
        }
        QuotesPagerIndicator(pagerState = pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun EmptyQuotesPager(
    modifier: Modifier = Modifier
) {

    val listQuotes = listOf(
        R.string.text_quotes,
        R.string.text_quotes,
        R.string.text_quotes,
    )

    val pagerState = rememberPagerState(initialPage = 0)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = listQuotes.size,
            state = pagerState,
            itemSpacing = 10.dp
        ) { pager ->
            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(3.dp, PurpleMainColor, shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = stringResource(listQuotes[pager]),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp).fillMaxSize()
                )
            }
        }
        QuotesPagerIndicator(pagerState = pagerState)
    }
}