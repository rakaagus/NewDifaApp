package com.artforyou.difa.presentation.screen.detection

import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.rounded.FlashOff
import androidx.compose.material.icons.rounded.FlashOn
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artforyou.difa.R
import com.artforyou.difa.presentation.components.header.GlobalTopBar
import com.artforyou.difa.presentation.screen.detection.component.CameraDetection
import com.artforyou.difa.ui.theme.blueLight
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@Composable
fun SibiDetectionScreen(
    onBackPress: () -> Unit = {}
){
    Scaffold(
        containerColor = Color.White,
        topBar = {
            GlobalTopBar(
                pageTitle = stringResource(R.string.text_detection),
                onBackPressed = onBackPress,
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        SibiDetectionContent(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SibiDetectionContent(
    modifier: Modifier = Modifier,
) {

    var camera by remember { mutableStateOf<Camera?>(null) }
    var flashOn by remember { mutableStateOf(false) }
    var cameraSelector by remember { mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp)
        ) {
            SimpleInformation(
                title = "Huruf Sibi",
                value = "Sibi",
                modifier = Modifier
                    .weight(1f)
            )

            SimpleInformation(
                title = "Presentasi Deteksi",
                value = "90%",
                isOrientationEnd = true,
                modifier = Modifier
                    .weight(1f)
            )
        }

        CameraDetection(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
                .padding(top = 10.dp)
                .clip(MaterialTheme.shapes.small),
            cameraSelector = cameraSelector,
            onRecognition = { result ->

            },
            onCameraReady = {
                camera = it
                camera?.cameraControl?.enableTorch(flashOn)
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            IconButton(
                onClick = {
                    cameraSelector =
                        if (cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA)
                            CameraSelector.DEFAULT_FRONT_CAMERA
                        else
                            CameraSelector.DEFAULT_BACK_CAMERA
                },
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.Center)
            ) {
                Icon(
                    imageVector = Icons.Default.Cameraswitch,
                    tint = blueLight,
                    contentDescription = "Change Camera",
                    modifier = Modifier
                        .size(80.dp)
                )
            }
            IconButton(
                onClick = {
                    flashOn = !flashOn
                    camera?.cameraControl?.enableTorch(flashOn)
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x51000000),
                ),
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = (-50).dp),
            ) {
                Icon(
                    imageVector = if (flashOn) Icons.Rounded.FlashOn else Icons.Rounded.FlashOff,
                    tint = Color.White,
                    contentDescription = "Turn on The Flash"
                )
            }
        }
    }
}

@Composable
fun SimpleInformation(
    title: String,
    value: String,
    modifier: Modifier,
    isOrientationEnd: Boolean = false,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = if (isOrientationEnd) Alignment.End else Alignment.Start
    ) {
        Text(
            title,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Normal
            )
        )
        Text(
            value,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Bold
            ),
            textAlign = if (isOrientationEnd) TextAlign.End else TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SibiDetectionScreenPrev() {
    SibiDetectionScreen()
}