package com.synth.partner.domain.repository

import com.synth.partner.domain.model.User

interface PartnerAuthRepository {
    suspend fun signInWithGoogle(idToken: String): User
}