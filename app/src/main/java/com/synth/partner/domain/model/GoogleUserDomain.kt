package com.synth.partner.domain.model

data class GoogleUserDomain(
    val sub: String?,           // ID người dùng Google
    val email: String?,
    val emailVerified: Boolean?,
    val fullName: String?,
    val givenName: String?,
    val familyName: String?,
    val picture: String?,
    val issuedAt: Long?,
    val expirationTime: Long?,
    val locale: String?
)