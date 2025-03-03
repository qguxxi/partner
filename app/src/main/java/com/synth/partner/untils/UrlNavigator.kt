package com.synth.partner.untils

import android.content.Context
import android.content.Intent
import android.net.Uri

object UrlNavigator {
    fun openUrl(url: String,context: Context) {
        val intent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
        context.startActivity(intent)
    }
}