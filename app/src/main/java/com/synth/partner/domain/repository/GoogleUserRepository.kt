package com.synth.partner.domain.repository

import com.stevdzasan.onetap.GoogleUser
import com.synth.partner.domain.model.GoogleUserDomain

interface GoogleUserRepository {

    suspend fun saveGoogleUser(googleUser: GoogleUser?)

    suspend fun getGoogleUserBySub(sub: String): GoogleUserDomain?
}