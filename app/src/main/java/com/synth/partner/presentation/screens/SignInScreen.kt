package com.synth.partner.presentation.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.getUserFromTokenId
import com.stevdzasan.onetap.rememberOneTapSignInState
import com.synth.partner.BuildConfig
import com.synth.partner.R
import com.synth.partner.presentation.components.GoogleButton
import com.synth.partner.presentation.components.PrivacyAndTerm
import com.synth.partner.presentation.theme.logoFont
import com.synth.partner.presentation.viewmodel.AuthViewModel
import com.synth.partner.presentation.viewmodel.GoogleUserViewModel
import com.synth.partner.untils.UrlNavigator

@Composable
fun SignInScreen(
    onLoginSuccess:() -> Unit,
    authViewModel: AuthViewModel = hiltViewModel(),
    googleUserViewModel: GoogleUserViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = rememberOneTapSignInState()
    OneTapSignInWithGoogle(
        state = state,
        clientId = BuildConfig.WEB_CLIENT_ID,
        onTokenIdReceived = { tokenId ->
            authViewModel.saveLoginState(true, tokenId)
            getUserFromTokenId(tokenId)
            onLoginSuccess()
            Log.d("LOG", "Token id client : $tokenId")
            Log.d("GoogleUser", getUserFromTokenId(tokenId).toString())
            googleUserViewModel.saveGoogleUser(getUserFromTokenId(tokenId))

        },
        onDialogDismissed = { message ->
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
            Log.d("LOG", message)
        }
    )

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
        ) {
            Spacer(Modifier.weight(1f))
            LogoSection()
            Spacer(Modifier.weight(1f))
            ButtonsSection(
                onGoogleClick = { state.open() },
                isLoading = state.opened,
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
            imageVector = ImageVector.vectorResource(id = (R.drawable.partner_icon)) ,
            tint = Color.Unspecified ,
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.app_name) ,
            style = logoFont,
        )
    }
}

@Composable
fun ButtonsSection(onGoogleClick : () -> Unit ,isLoading: Boolean, context : Context) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        GoogleButton(onGoogleClick = onGoogleClick,isLoading)
        Spacer(modifier = Modifier.height(16.dp))
        PrivacyAndTerm(privacyOnClick = {
            UrlNavigator.openUrl("https://sites.google.com/view/synthinc/trang-ch%E1%BB%A7" , context)
        } , termServiceOnClick = {
            UrlNavigator.openUrl("https://sites.google.com/view/synth-inc/trang-ch%E1%BB%A7" , context)
        })
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4A)
@Composable
private fun SignInScreenPreview() {
    SignInScreen(
        onLoginSuccess = {}
    )
}