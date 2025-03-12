package com.synth.partner.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun isLoggedIn(): Boolean
    fun saveLoginState(isLoggedIn: Boolean, token: String?)
}