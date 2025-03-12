package com.synth.partner.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.synth.partner.domain.repository.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AuthRepository {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    override fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged_in", false)
    }

    override fun saveLoginState(isLoggedIn: Boolean, token: String?) {
        with(prefs.edit()) {
            putBoolean("is_logged_in", isLoggedIn)
            if (token != null) putString("auth_token", token)
            commit()
        }
    }
}