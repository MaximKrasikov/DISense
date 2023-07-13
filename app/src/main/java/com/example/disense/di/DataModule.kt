package com.example.disense.di

import android.content.Context
import com.example.disense.data.repository.UserRepositoryImpl
import com.example.disense.data.storage.UserStorage
import com.example.disense.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.disense.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage{
        return SharedPrefUserStorage(context = context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository{
        return  UserRepositoryImpl(
            userStorage = userStorage
        )
    }
}