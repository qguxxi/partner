package com.synth.partner.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.synth.partner.domain.model.User
import com.synth.partner.domain.usecase.SignInWithGoogleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor (
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase
): ViewModel() {

    private val _user = mutableStateOf<User?>(null)
    val user: State<User?> = _user

    private val auth = FirebaseAuth.getInstance()

    private val _loginError = mutableStateOf<String?>(null)
    val loginError: State<String?> = _loginError

    init {
        checkCurrentUser()
    }

    private fun checkCurrentUser() {
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        if (firebaseUser != null) {
            _user.value = User(firebaseUser.uid, null) // partnerId cập nhật sau
        }
    }


    fun signInWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Đăng nhập thành công
                } else {
                    // Đăng nhập thất bại
                }
            }
    }
}