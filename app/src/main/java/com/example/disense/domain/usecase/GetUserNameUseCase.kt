package com.example.disense.domain.usecase

import com.example.disense.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName{
        return UserName(firstName = "Maximochka", lastName = "Krasikov")
    }

}