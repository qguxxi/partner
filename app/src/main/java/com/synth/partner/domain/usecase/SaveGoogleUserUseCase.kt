package com.synth.partner.domain.usecase

import com.stevdzasan.onetap.GoogleUser
import com.synth.partner.domain.repository.GoogleUserRepository
import javax.inject.Inject

class SaveGoogleUserUseCase @Inject constructor(
    private val googleUserRepository: GoogleUserRepository
) {
    suspend operator fun invoke(googleUser: GoogleUser?) {
        googleUserRepository.saveGoogleUser(googleUser)
    }
}