package com.synth.partner.domain.repository

import com.synth.partner.domain.model.User

interface AuthRepository {
    suspend fun signInWithGoogle(idToken: String): Result<User>
    fun getCurrentUser(): User?
}