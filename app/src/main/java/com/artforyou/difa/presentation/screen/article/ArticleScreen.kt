package com.artforyou.difa.presentation.screen.article

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.artforyou.difa.R
import com.artforyou.difa.presentation.components.header.GlobalTopBar
import com.artforyou.difa.ui.theme.activeTextBlue

@Composable
fun ArticleScreen(
    onBackPressed: () -> Unit,
    url: String = "",
    modifier: Modifier = Modifier
){

    var isLoading = remember { mutableStateOf(false) }
    val webViewState = remember { mutableStateOf<WebView?>(null) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Column {
                GlobalTopBar(
                    pageTitle = stringResource(R.string.text_article),
                    onBackPressed = onBackPressed,
                ){
                    IconButton(onClick = { webViewState.value?.reload() }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = stringResource(R.string.img_reload),
                            tint = activeTextBlue
                        )
                    }
                }
                if(isLoading.value){
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth(),
                        color = activeTextBlue
                    )
                }
            }
        },
    ) { paddingValues ->
        ArticleScreenContent(
            modifier = Modifier.padding(paddingValues),
            url = url,
            isLoading = isLoading,
            webViewState = webViewState
        )
    }
}

@Composable
fun ArticleScreenContent(
    modifier: Modifier = Modifier,
    url: String,
    isLoading: MutableState<Boolean>,
    webViewState: MutableState<WebView?>
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = object : WebViewClient() {
                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        super.onPageStarted(view, url, favicon)
                        isLoading.value = true
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        isLoading.value = false
                    }
                }
                loadUrl(url)
                webViewState.value = this  // Simpan referensi WebView
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun ArticleScreenPreview() {
    ArticleScreen(
        onBackPressed = {},
        url = "https://www.halodoc.com/artikel/wajib-tahu-ini-perbedaan-tunarungu-dan-tuli?srsltid=AfmBOorFJxhj4h5loijOEM7eQP6A2R4krvz3qsXyy7xAFNQUPJ8e9m8R"
    )
}