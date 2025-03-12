package com.synth.partner.domain.usecase


import com.synth.partner.domain.repository.AuthRepository
import javax.inject.Inject

class SaveLoginStateUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(isLoggedIn: Boolean, token: String?) {
        authRepository.saveLoginState(isLoggedIn, token)
    }
}