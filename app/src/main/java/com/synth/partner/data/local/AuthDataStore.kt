package com.synth.partner.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.authDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class AuthDataStore (private val context: Context) {
    companion object {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val AUTH_TOKEN = stringPreferencesKey("auth_token")
    }

    suspend fun saveLoginState(isLoggedIn: Boolean, idToken: String? = null) {
        context.authDataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = isLoggedIn
            if (idToken != null) {
                preferences[AUTH_TOKEN] = idToken
            }
        }
    }

    val isLoggedIn: Flow<Boolean> = context.authDataStore.data
        .map { prefs -> prefs[IS_LOGGED_IN] ?: false }

    val authToken: Flow<String?> = context.authDataStore.data
        .map { prefs -> prefs[AUTH_TOKEN] }


}