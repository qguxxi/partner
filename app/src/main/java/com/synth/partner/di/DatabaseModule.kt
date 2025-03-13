package com.synth.partner.di

import android.content.Context
import androidx.room.Room
import com.synth.partner.data.local.room.GoogleUserDao
import com.synth.partner.data.local.room.PartnerDatabase
import com.synth.partner.data.local.room.databaseName
import com.synth.partner.data.repository.GoogleUserRepositoryImpl
import com.synth.partner.domain.repository.GoogleUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PartnerDatabase {
        return Room.databaseBuilder(
            context,
            PartnerDatabase ::class.java,
            databaseName
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideGoogleUserDao(database: PartnerDatabase): GoogleUserDao {
        return database.googleUserDao()
    }

    @Provides
    @Singleton
    fun provideGoogleUserRepository(googleUserDao: GoogleUserDao): GoogleUserRepository {
        return GoogleUserRepositoryImpl(googleUserDao)
    }
}