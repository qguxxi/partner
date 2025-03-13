package com.synth.partner.domain.usecase

import com.synth.partner.domain.repository.AuthRepository
import javax.inject.Inject


class CheckLoginStateUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Boolean {
        return authRepository.isLoggedIn()
    }
}