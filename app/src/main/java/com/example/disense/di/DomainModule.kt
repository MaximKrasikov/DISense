package com.example.disense.di

import com.example.disense.domain.repository.UserRepository
import com.example.disense.domain.usecase.GetUserNameUseCase
import com.example.disense.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    // замена провайдов на inject конструктора - оптимизация кода
  /*  @Provides
    fun provideGetUserNameUseCase(userRepository:UserRepository) : GetUserNameUseCase{
        return  GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository:UserRepository) : SaveUserNameUseCase{
        return  SaveUserNameUseCase(
            userRepository = userRepository
        )
    }*/
}