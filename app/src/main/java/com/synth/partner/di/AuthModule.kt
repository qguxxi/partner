package com.synth.partner.di

import android.content.Context
import com.synth.partner.data.local.AuthDataStore
import com.synth.partner.data.repository.AuthRepositoryImpl
import com.synth.partner.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository = repository
}