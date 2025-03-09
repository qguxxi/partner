package com.synth.partner.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.synth.partner.R
import com.synth.partner.presentation.components.ContinueButton
import com.synth.partner.presentation.components.LocaleSection


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocalePermissionScreen() {
    val permissionState = rememberPermissionState(android.Manifest.permission.ACCESS_FINE_LOCATION)
    val context = LocalContext.current
    val hasPermission = permissionState.status.isGranted
    val requestPermission = rememberUpdatedState {
        when {
            hasPermission -> {
                Toast.makeText(context, "Quyền đã được cấp!", Toast.LENGTH_SHORT).show()
            }
            permissionState.status.shouldShowRationale -> {
                Toast.makeText(context, "Ứng dụng cần quyền truy cập vị trí để hoạt động.", Toast.LENGTH_LONG).show()
                permissionState.launchPermissionRequest()
            }
            else -> {
                permissionState.launchPermissionRequest()
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp)
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.map_1),
                    contentDescription = null,
                    modifier = Modifier.background(
                        MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp)
                    )
                )
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxHeight(0.5f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile__1),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.None
                    )
                    Image(
                        painter = painterResource(R.drawable.profile_2),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.None
                    )
                }
            }

            LocaleSection()

            ContinueButton(
                onClick = { requestPermission.value.invoke() },
                text = "Cấp quyền chia sẻ vị trí",
                modifier = Modifier.padding(bottom = 36.dp)
            )
        }
    }
}

@Preview
@Composable
private fun LocalePermissionScreenPreview() {
    LocalePermissionScreen()
}
