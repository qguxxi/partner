package com.synth.partner.untils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

object UrlNavigator {
    fun openUrl(url: String,context: Context) {
        // navigate to url
        try {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
            context.startService(intent)
        } catch (e : Exception) {
            e.printStackTrace()
            Log.d("URL", "Error: $e")
        }
    }
}