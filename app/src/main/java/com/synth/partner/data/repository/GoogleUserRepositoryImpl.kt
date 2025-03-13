package com.synth.partner.data.repository

import com.stevdzasan.onetap.GoogleUser
import com.synth.partner.data.local.room.GoogleUserDao
import com.synth.partner.data.model.GoogleUserEntity
import com.synth.partner.domain.repository.GoogleUserRepository
import javax.inject.Inject

class GoogleUserRepositoryImpl @Inject constructor(private val googleUserDao: GoogleUserDao) : GoogleUserRepository {
    override suspend fun getGoogleUserBySub(sub: String): com.synth.partner.domain.model.GoogleUserDomain {
        return googleUserDao.getGoogleUser(sub).toDomain()
    }

    override suspend fun saveGoogleUser(googleUser: GoogleUser?) {
        googleUserDao.insertGoogleUser(googleUser!!.toEntity())
    }

    // Mapper functions
    private fun com.synth.partner.domain.model.GoogleUserDomain.toEntity() = GoogleUserEntity(
        sub = sub.orEmpty(),
        email = email,
        emailVerified = emailVerified,
        fullName = fullName,
        givenName = givenName,
        familyName = familyName,
        picture = picture,
        issuedAt = issuedAt,
        expirationTime = expirationTime,
        locale = locale
    )

    private fun GoogleUser.toEntity() = GoogleUserEntity(
        sub = sub.orEmpty(),
        email = email,
        emailVerified = emailVerified,
        fullName = fullName,
        givenName = givenName,
        familyName = familyName,
        picture = picture,
        issuedAt = issuedAt,
        expirationTime = expirationTime,
        locale = locale
    )

    private fun GoogleUserEntity.toDomain() = com.synth.partner.domain.model.GoogleUserDomain(
        sub = sub,
        email = email,
        emailVerified = emailVerified,
        fullName = fullName,
        givenName = givenName,
        familyName = familyName,
        picture = picture,
        issuedAt = issuedAt,
        expirationTime = expirationTime,
        locale = locale
    )
}