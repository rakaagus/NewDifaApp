package com.artforyou.difa.utils.extension

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object Route {
    fun openYoutubeUrl(context: Context, url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Gagal membuka tautan", Toast.LENGTH_SHORT).show()
        }
    }
}