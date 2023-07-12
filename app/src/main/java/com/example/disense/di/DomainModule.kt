package com.example.disense.di

import com.example.disense.domain.usecase.GetUserNameUseCase
import com.example.disense.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(
            userRepository = get()
        )
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(
            userRepository = get()
        )
    }

}