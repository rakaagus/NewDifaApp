package com.artforyou.difa.utils.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.artforyou.difa.R
import com.artforyou.difa.ui.theme.RedDark
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight


/*
* How To Use
* have 4 parameter with 2 parameter is default.
* you mus set parameter OnDismiss and onCLickRefresh.
* */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onClickRefresh: () -> Unit,
    title: String = stringResource(R.string.text_error_title_default),
    description: String = stringResource(R.string.text_error_desc_default),
) {
    val modalBottomSheet = rememberModalBottomSheetState()

    LaunchedEffect(modalBottomSheet.isVisible) {
        if (modalBottomSheet.isVisible){
            onDismiss()
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = modalBottomSheet,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Color.White,
        shape = MaterialTheme.shapes.large,
        modifier = modifier
    ) {
        ErrorBottomSheetContent(
            title = title,
            description = description,
            onDismiss = onDismiss,
            onTryAgainClick = onClickRefresh,
        )
    }
}

@Composable
fun ErrorBottomSheetContent(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onDismiss: () -> Unit,
    onTryAgainClick: () -> Unit,
) {
    val lottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_failed))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier.fillMaxWidth().padding(bottom = 20.dp)
    ) {
        LottieAnimation(
            composition = lottieComposition,
            modifier = Modifier.size(120.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = Color.Black
        )
        Text(
            text = description,
            style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 14.sp
            ),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            TextButton(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(backgroundColor = RedDark),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.size(width = 160.dp, height = 50.dp)
            ) {
                Text(
                    text = stringResource(R.string.text_cancle),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White
                )
            }
            TextButton(
                onClick = onTryAgainClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = blueLight),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.size(width = 160.dp, height = 50.dp)
            ) {
                Text(
                    text = stringResource(R.string.text_try_again),
                    style = MaterialTheme.typography.labelLarge,
                    color = activeTextBlue
                )
            }
        }
    }
}

/*
* Preview ErrorBottomSheet
* Please use Interactive Mode
* */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun ErrorBottomSheetPrev() {
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    LaunchedEffect(Unit) {
        modalBottomSheetState.show()
    }

    Scaffold(
        contentColor = Color.White,
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ) {
            ModalBottomSheet(
                onDismissRequest = {},
                containerColor = Color.White,
                sheetState = modalBottomSheetState,
                dragHandle = { BottomSheetDefaults.DragHandle() },
            ) {
                ErrorBottomSheetContent(
                    title = stringResource(R.string.text_error_title_default),
                    description = stringResource(R.string.text_error_desc_default),
                    onDismiss = {},
                    onTryAgainClick = {}
                )
            }
        }
    }
}