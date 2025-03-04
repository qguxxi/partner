package com.synth.partner.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.synth.partner.domain.use_case.SignInWithGoogleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoogleSignInViewModel @Inject constructor(
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<GoogleSignInUiState>(GoogleSignInUiState.Initial)
    val uiState: StateFlow<GoogleSignInUiState> = _uiState.asStateFlow()

    fun signInWithGoogle(account: GoogleSignInAccount) {
        viewModelScope.launch {
            _uiState.value = GoogleSignInUiState.Loading
            signInWithGoogleUseCase(account)
                .onSuccess {
                    _uiState.value = GoogleSignInUiState.Success
                }
                .onFailure { error ->
                    _uiState.value = GoogleSignInUiState.Error(error.message ?: "Đăng nhập thất bại")
                }
        }
    }
}

sealed class GoogleSignInUiState {
    object Initial : GoogleSignInUiState()
    object Loading : GoogleSignInUiState()
    object Success : GoogleSignInUiState()
    data class Error(val message: String) : GoogleSignInUiState()
} 