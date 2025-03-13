package com.synth.partner.presentation.screens

import android.Manifest
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.synth.partner.R
import com.synth.partner.presentation.components.ContinueButton
import com.synth.partner.presentation.components.LocaleSection


@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocalePermissionScreen(
    onPermissionGranted: () -> Unit = {}
) {
    // Trạng thái quyền truy cập vị trí foreground và background
    val fineLocationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
    val backgroundLocationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
    val context = LocalContext.current

    // Kiểm tra trạng thái quyền
    val hasFineLocationPermission = fineLocationPermissionState.status.isGranted
    val hasBackgroundLocationPermission = backgroundLocationPermissionState.status.isGranted

    // Hàm xử lý yêu cầu quyền
    val requestPermissions = {
        when {
            // Nếu chưa có quyền foreground, yêu cầu trước
            !hasFineLocationPermission -> {
                if (fineLocationPermissionState.status.shouldShowRationale) {
                    Toast.makeText(
                        context,
                        "Ứng dụng cần quyền truy cập vị trí để hoạt động.",
                        Toast.LENGTH_LONG
                    ).show()
                }
                fineLocationPermissionState.launchPermissionRequest()
            }
            // Nếu đã có quyền foreground nhưng chưa có quyền background, yêu cầu quyền background
            hasFineLocationPermission && !hasBackgroundLocationPermission -> {
                if (backgroundLocationPermissionState.status.shouldShowRationale) {
                    Toast.makeText(
                        context,
                        "Ứng dụng cần quyền truy cập vị trí khi chạy nền.",
                        Toast.LENGTH_LONG
                    ).show()
                }
                backgroundLocationPermissionState.launchPermissionRequest()
            }
            // Nếu cả hai quyền đã được cấp, gọi callback
            hasFineLocationPermission && hasBackgroundLocationPermission -> {
                Toast.makeText(context, "Quyền đã được cấp!", Toast.LENGTH_SHORT).show()
                onPermissionGranted()
            }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.error)
            .windowInsetsPadding(WindowInsets(0, 0, 0, 0))
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
        ) {
            // Phần hình ảnh phía trên
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

            // Phần LocaleSection (giả định đã được định nghĩa)
            LocaleSection()

            // Nút tiếp tục
            ContinueButton(
                onClick = { requestPermissions() },
                text = when {
                    !hasFineLocationPermission -> "Cấp quyền truy cập vị trí"
                    !hasBackgroundLocationPermission -> "Cấp quyền chạy nền"
                    else -> "Tiếp tục"
                },
                modifier = Modifier.padding(bottom = 36.dp)
            )
        }
    }

    // Hiệu ứng phụ để kiểm tra khi quyền thay đổi
    LaunchedEffect(fineLocationPermissionState.status, backgroundLocationPermissionState.status) {
        if (hasFineLocationPermission && hasBackgroundLocationPermission) {
            onPermissionGranted()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun LocalePermissionScreenPreview() {
    LocalePermissionScreen()
}
