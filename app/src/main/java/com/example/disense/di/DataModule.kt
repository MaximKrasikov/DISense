package com.example.disense.di

import com.example.disense.data.repository.UserRepositoryImpl
import com.example.disense.data.storage.UserStorage
import com.example.disense.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.disense.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module{

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }
    single<UserRepository>{
        UserRepositoryImpl(userStorage = get())
    }

}