package com.synth.partner.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevdzasan.onetap.GoogleUser
import com.synth.partner.domain.usecase.SaveGoogleUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoogleUserViewModel @Inject constructor(
    private val saveGoogleUserUseCase: SaveGoogleUserUseCase,
): ViewModel() {

    fun saveGoogleUser(googleUser: GoogleUser?) {
        viewModelScope.launch(Dispatchers.IO) {
            saveGoogleUserUseCase(googleUser)
        }
    }

}