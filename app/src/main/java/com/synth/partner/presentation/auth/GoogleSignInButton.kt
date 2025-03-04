package com.synth.partner.presentation.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

@Composable
fun GoogleSignInButton(
    onSignInSuccess: () -> Unit,
    viewModel: GoogleSignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Button(
        onClick = { /* Sẽ được xử lý bởi Activity */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Đăng nhập với Google")
    }

    when (uiState) {
        is GoogleSignInUiState.Success -> onSignInSuccess()
        is GoogleSignInUiState.Error -> {
            // Hiển thị thông báo lỗi
        }
        else -> {}
    }
} 