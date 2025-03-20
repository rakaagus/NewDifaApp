package com.artforyou.difa.presentation.screen.detection

import android.Manifest
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.UseCase
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.rounded.FlashOff
import androidx.compose.material.icons.rounded.FlashOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.artforyou.difa.presentation.components.header.GlobalTopBar
import com.artforyou.difa.presentation.screen.detection.component.CameraPreview
import com.artforyou.difa.ui.theme.blueLight
import com.artforyou.difa.utils.getCameraProvider
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@Composable
fun SibiDetectionScreen(
    onBackPress: () -> Unit = {}
){
    Scaffold(
        containerColor = Color.White,
        topBar = {
            GlobalTopBar(
                pageTitle = "Sibi Detection",
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
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
) {

    val context = LocalContext.current
    val permissionState = rememberPermissionState(
        Manifest.permission.CAMERA
    )

    LaunchedEffect(Unit) {
        if (!permissionState.status.isGranted) {
            permissionState.launchPermissionRequest()
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        val lifecycleOwner = LocalLifecycleOwner.current
        var previewUseCase by remember { mutableStateOf<UseCase>(androidx.camera.core.Preview.Builder().build()) }
        var flashModeOn by remember { mutableStateOf(false) }

        val imageCaptureUseCase by remember {
            mutableStateOf(
                ImageCapture.Builder()
                    .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                    .build()
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 20.dp)
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

        CameraPreview(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
                .padding(top = 10.dp)
                .clip(MaterialTheme.shapes.small),
            onUseCase = { usecase ->
                previewUseCase = usecase
            }
        )

        Box(
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
        ) {
            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.Center)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Circle,
                    tint = blueLight,
                    contentDescription = "Scan",
                    modifier = Modifier
                        .size(80.dp)
                )
            }
            IconButton(
                onClick = {
                    flashModeOn = !flashModeOn
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
                    imageVector = if (flashModeOn)
                        Icons.Rounded.FlashOn else Icons.Rounded.FlashOff,
                    tint = Color.White,
                    contentDescription = "Turn on The Flash"
                )
            }
        }

        LaunchedEffect(previewUseCase, flashModeOn) {
            val cameraProvider = context.getCameraProvider()
            try {
                cameraProvider.unbindAll()
                val camera = cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    previewUseCase,
                    imageCaptureUseCase
                )
                if (camera.cameraInfo.hasFlashUnit()) {
                    camera.cameraControl.enableTorch(flashModeOn)
                }
            } catch (e: Exception) {
                Log.e("Camera Content", "ScanContent: $e")
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