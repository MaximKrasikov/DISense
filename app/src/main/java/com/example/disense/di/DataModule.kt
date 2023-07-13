package com.example.disense.di

import android.content.Context
import com.example.disense.data.repository.UserRepositoryImpl
import com.example.disense.data.storage.UserStorage
import com.example.disense.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.disense.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(
            context = context
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(
            userStorage = userStorage
        )
    }
}