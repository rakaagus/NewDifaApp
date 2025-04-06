package com.artforyou.difa.utils.extension

import android.content.Context
import androidx.camera.lifecycle.ProcessCameraProvider

fun Context.getCameraProvider(): ProcessCameraProvider {
    val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
    return cameraProviderFuture.get()
}