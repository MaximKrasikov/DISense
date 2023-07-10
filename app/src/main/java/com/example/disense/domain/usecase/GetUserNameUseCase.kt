package com.example.disense.domain.usecase

import com.example.disense.domain.models.UserName
import com.example.disense.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }

}