package com.synth.partner.domain.usecase


import com.synth.partner.domain.model.User
import com.synth.partner.domain.repository.PartnerAuthRepository


class SignInWithGoogleUseCase(
    private val repository: PartnerAuthRepository
) {
    suspend operator fun invoke(idToken: String): User {
        return repository.signInWithGoogle(idToken)
    }
}

