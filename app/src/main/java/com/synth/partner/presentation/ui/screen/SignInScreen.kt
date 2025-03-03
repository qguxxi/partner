
package com.synth.partner.presentation.ui.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.synth.partner.R
import com.synth.partner.presentation.ui.components.GoogleButton
import com.synth.partner.presentation.ui.components.PrivacyAndTerm
import com.synth.partner.presentation.ui.theme.logo
import com.synth.partner.presentation.viewmodel.SignInViewModel
import com.synth.partner.untils.UrlNavigator

@Composable
fun SignInScreen(
    signInViewModel: SignInViewModel = hiltViewModel()
) {
    val context = LocalContext.current



    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            Spacer(Modifier.weight(1f))
            LogoSection()
            Spacer(Modifier.weight(1f))
            ButtonsSection(
                onGoogleClick = { signInViewModel },
                context
            )
        }
    }
}

@Composable
fun LogoSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.spacedBy(16.dp) ,
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.logo_signin) ,
            tint = Color.Unspecified ,
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.app_name) ,
            style = logo
        )
    }
}

@Composable
fun ButtonsSection(onGoogleClick : () -> Unit , context : Context) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        GoogleButton(onGoogleClick = onGoogleClick)
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        PrivacyAndTerm(privacyOnClick = {
            UrlNavigator.openUrl("https://sites.google.com/view/synthinc/trang-ch%E1%BB%A7" , context)
        } , termServiceOnClick = {
            UrlNavigator.openUrl("https://sites.google.com/view/synth-inc/trang-ch%E1%BB%A7" , context)
        })
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}