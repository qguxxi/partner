package com.synth.partner.di


import com.synth.partner.data.repository.PartnerAuthRepositoryImpl
import com.synth.partner.domain.repository.PartnerAuthRepository
import com.synth.partner.domain.usecase.SignInWithGoogleUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PartnerAppModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): PartnerAuthRepository {
        return PartnerAuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideSignInWithGoogleUseCase(repository: PartnerAuthRepository): SignInWithGoogleUseCase {
        return SignInWithGoogleUseCase(repository)
    }

    // Thêm các provide khác nếu cần (Location, Pairing...)
}