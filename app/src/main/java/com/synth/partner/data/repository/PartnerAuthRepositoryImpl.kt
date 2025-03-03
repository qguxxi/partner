package com.synth.partner.data.repository

import com.synth.partner.domain.model.User
import com.synth.partner.domain.repository.PartnerAuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PartnerAuthRepositoryImpl (
    private val firebaseAuth: FirebaseAuth
) : PartnerAuthRepository {
    override suspend fun signInWithGoogle(idToken: String): User = suspendCoroutine { cont ->
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                val firebaseUser = authResult.user
                if (firebaseUser != null) {
                    val user = User(
                        id = firebaseUser.uid,
                        partnerId = null // Sẽ cập nhật từ backend nếu cần
                    )
                    cont.resume(user)
                } else {
                    cont.resumeWithException(Exception("Không thể đăng nhập"))
                }
            }
            .addOnFailureListener { exception ->
                cont.resumeWithException(exception)
            }
    }
}