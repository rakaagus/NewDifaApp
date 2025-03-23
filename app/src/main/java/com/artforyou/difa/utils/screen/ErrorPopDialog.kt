package com.artforyou.difa.utils.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.artforyou.difa.R
import com.artforyou.difa.ui.theme.RedDark
import com.artforyou.difa.ui.theme.activeTextBlue
import com.artforyou.difa.ui.theme.blueLight

@Composable
fun ErrorPopDialog(
    onDismiss: () -> Unit,
    onRefreshClick: () -> Unit,
    title: String = stringResource(R.string.text_error_title_default),
    description: String = stringResource(R.string.text_error_desc_default),
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        ErrorPopUpDialogContent(
            onDismiss = onDismiss,
            onRefreshClick = onRefreshClick,
            title = title,
            description = description
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorPopUpDialogContent(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onRefreshClick: () -> Unit,
    title: String,
    description: String,
) {
    Card (
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = MaterialTheme.shapes.small,
        modifier = modifier.padding(16.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier.fillMaxWidth().offset(y = 10.dp, x = (-10).dp)
            ) {
                IconButton(
                    onClick = onDismiss,
                    colors = IconButtonDefaults.iconButtonColors(containerColor = RedDark),
                    enabled = true,
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.img_close_button),
                        tint = Color.White
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.img_onboarding_2),
                contentDescription = stringResource(R.string.img_pop_error),
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
            TextButton(
                onClick = onRefreshClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = blueLight),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 16.dp)
            ) {
                androidx.compose.material.Text(
                    text = stringResource(R.string.text_try_again),
                    style = MaterialTheme.typography.labelLarge,
                    color = activeTextBlue
                )
            }
        }
    }
}

@Preview
@Composable
private fun ErrorDialogPopPreview() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Button(onClick = { showDialog = true }) {
                Text("Show PopUp Dialog")
            }
        }

        if (showDialog) {
            ErrorPopDialog(
                onDismiss = { showDialog = false },
                onRefreshClick = { /* Tambahkan aksi di sini */ }
            )
        }
    }
}