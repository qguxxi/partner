package com.synth.partner.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "google_user")
data class GoogleUserEntity(
    @PrimaryKey(autoGenerate = false)
    val sub: String,
    val email: String?,
    val emailVerified: Boolean?,
    val fullName: String?,
    val givenName: String?,
    val familyName: String?,
    val picture: String?,
    val issuedAt: Long?,
    val expirationTime: Long?,
    val locale: String?,
)