package com.synth.partner.di


import android.app.Application
import android.content.Context
import com.synth.partner.data.repository.PartnerAuthRepositoryImpl
import com.synth.partner.domain.repository.PartnerAuthRepository
import com.synth.partner.domain.usecase.SignInWithGoogleUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PartnerAppModule {
    @Provides
    @Singleton
    fun provideApplication(@ApplicationContext context: Context): Application {
        return context as Application
    }



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
    fun provideSignInWithGoogleUseCase(@ApplicationContext context: Context,repository: PartnerAuthRepository): SignInWithGoogleUseCase {
        return SignInWithGoogleUseCase(context,repository)
    }

    // Thêm các provide khác nếu cần (Location, Pairing...)
}