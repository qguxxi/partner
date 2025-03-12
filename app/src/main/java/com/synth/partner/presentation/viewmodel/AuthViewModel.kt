package com.synth.partner.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.synth.partner.domain.usecase.CheckLoginStateUseCase
import com.synth.partner.domain.usecase.SaveLoginStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val checkLoginStateUseCase: CheckLoginStateUseCase,
    private val saveLoginStateUseCase: SaveLoginStateUseCase
) : ViewModel() {

    // Kiểm tra trạng thái đồng bộ
    fun isLoggedIn(): Boolean = checkLoginStateUseCase()

    fun saveLoginState(isLoggedIn: Boolean, token: String?) {
        saveLoginStateUseCase(isLoggedIn, token)
    }

}