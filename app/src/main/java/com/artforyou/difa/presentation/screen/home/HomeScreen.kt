package com.artforyou.difa.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.artforyou.difa.R
import com.artforyou.difa.SetStatusBarColor
import com.artforyou.difa.data.Resource
import com.artforyou.difa.domain.model.ArticleModel
import com.artforyou.difa.presentation.screen.home.component.ArticleShimmer
import com.artforyou.difa.presentation.screen.home.component.EmptyQuotesPager
import com.artforyou.difa.presentation.screen.home.component.HomeAppbar
import com.artforyou.difa.presentation.screen.home.component.IconVerticalCard
import com.artforyou.difa.presentation.screen.home.component.LeftImageCard
import com.artforyou.difa.presentation.screen.home.component.QuoteShimmer
import com.artforyou.difa.presentation.screen.home.component.QuotesPager
import com.artforyou.difa.presentation.screen.home.component.RecommendationShimmer
import com.artforyou.difa.presentation.screen.home.component.RecommendationSibiCard
import com.artforyou.difa.presentation.screen.home.component.RightImageCard
import com.artforyou.difa.presentation.screen.home.component.VerticalArticleCard
import com.artforyou.difa.ui.theme.BlackColor
import com.artforyou.difa.ui.theme.GreenLight
import com.artforyou.difa.ui.theme.PurpleMainColor
import com.artforyou.difa.ui.theme.RedLight
import com.artforyou.difa.ui.theme.blueLight
import com.artforyou.difa.utils.extension.Route.openYoutubeUrl

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    moveToDetection: () -> Unit,
    moveToArticle: (ArticleModel) -> Unit,
    moveToAbout: () -> Unit,
    moveToPolicy: () -> Unit,
    moveToHelp: () -> Unit,
    moveToReport: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    SetStatusBarColor(color = PurpleMainColor)
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            HomeAppbar()
        }
    ) { paddingValues ->
        HomeScreenContent(
            moveToArticle = moveToArticle,
            moveToDetection = moveToDetection,
            homeViewModel = homeViewModel,
            moveToAbout = moveToAbout,
            moveToPolicy = moveToPolicy,
            moveToHelp = moveToHelp,
            moveToReport = moveToReport,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun HomeScreenContent(
    homeViewModel: HomeViewModel,
    moveToArticle: (ArticleModel) -> Unit,
    moveToDetection: () -> Unit,
    moveToAbout: () -> Unit,
    moveToPolicy: () -> Unit,
    moveToHelp: () -> Unit,
    moveToReport: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val quotesState = homeViewModel.quotes.collectAsState()
    val articleState = homeViewModel.articles.collectAsState()
    val recommendationState = homeViewModel.recommendations.collectAsState()
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.text_quotes),
                style = MaterialTheme.typography.labelLarge,
                color = BlackColor
            )
            Spacer(Modifier.height(10.dp))
            when(val result = quotesState.value){
                is Resource.Error -> {
                    EmptyQuotesPager()
                }
                is Resource.Loading -> {
                    QuoteShimmer()
                }
                is Resource.Success -> {
                    QuotesPager(quotes = result.data ?: emptyList())
                }
            }
            HomeSimpleTextFormat(
                title = stringResource(R.string.text_beranda),
                item = {
                    RightImageCard(
                        title = stringResource(R.string.text_start_header),
                        description = stringResource(R.string.text_start_description),
                        imageRes = R.drawable.mulai_komunikasi
                    ) {
                        moveToDetection()
                    }
                },
                item2 = {
                    LeftImageCard(
                        title = stringResource(R.string.text_about),
                        description = stringResource(R.string.title_about_1),
                        imageRes = R.drawable.about_app
                    ) {
                        moveToAbout()
                    }
                }
            )
            Spacer(Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                IconVerticalCard(
                    title = "Bantuan",
                    image = R.drawable.bantuan_img,
                ){
                    moveToHelp()
                }
                IconVerticalCard(
                    title = "Kebijakan",
                    image = R.drawable.kebijakan_image,
                ){
                    moveToPolicy()
                }
                IconVerticalCard(
                    title = "Laporkan",
                    image = R.drawable.laporan_img,
                ){
                    moveToReport()
                }
                IconVerticalCard(
                    title = "Pelajari",
                    image = R.drawable.tutorial_app,
                ){

                }
            }
            Spacer(Modifier.height(30.dp))
            HomeSimpleTextFormat(
                title = stringResource(R.string.text_recom_sibi),
                item = {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.height(300.dp)
                    ) {
                        when(val result = recommendationState.value){
                            is Resource.Error -> {
                                items(3) {
                                    RecommendationSibiCard()
                                }
                            }
                            is Resource.Loading -> {
                                items(3) {
                                    RecommendationShimmer()
                                }
                            }
                            is Resource.Success -> {
                                val limitedRecommendation = result.data?.take(3) ?: emptyList()
                                items(limitedRecommendation.size) { index ->
                                    RecommendationSibiCard(
                                        title = limitedRecommendation[index].title,
                                        description = limitedRecommendation[index].description,
                                        imageUrl = limitedRecommendation[index].urlImage
                                    ){
                                        val link = limitedRecommendation[index].link
                                        openYoutubeUrl(context, link)
                                    }
                                }
                            }
                        }
                    }
                }
            )
            Spacer(Modifier.height(30.dp))
            HomeTextFormatWithClickText(
                title = stringResource(R.string.text_article),
                text = stringResource(R.string.text_loadMore),
                onTextClick = {},
                item = {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(15.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        modifier = Modifier.height(600.dp)
                    ) {
                        when(val result = articleState.value){
                            is Resource.Error -> {
                                items(4) {
                                    VerticalArticleCard()
                                }
                            }
                            is Resource.Loading -> {
                                items(4) {
                                    ArticleShimmer()
                                }
                            }
                            is Resource.Success -> {
                                val limitedArticle = result.data?.take(4) ?: emptyList()
                                items(limitedArticle.size) { index ->
                                    VerticalArticleCard(
                                        title = limitedArticle[index].title,
                                        description = limitedArticle[index].description,
                                        imageUrl = limitedArticle[index].urlImage
                                    ) {
                                        moveToArticle(
                                            limitedArticle[index]
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun HomeSimpleTextFormat(
    modifier: Modifier = Modifier,
    title: String,
    item: @Composable () -> Unit,
    item2: (@Composable () -> Unit)? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = BlackColor
        )
        item()
        item2?.let { it() }
    }
}

@Composable
fun HomeTextFormatWithClickText(
    modifier: Modifier = Modifier,
    title: String,
    text: String = stringResource(R.string.text_quotes),
    onTextClick: () -> Unit,
    item: @Composable () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = BlackColor,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                textDecoration = TextDecoration.Underline,
                color = BlackColor,
                modifier = Modifier.clickable { onTextClick() }
            )
        }
        item()
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(
        moveToDetection = {},
        moveToArticle = {},
        moveToAbout = {},
        moveToPolicy = {},
        moveToReport = {},
        moveToHelp = {}
    )
}