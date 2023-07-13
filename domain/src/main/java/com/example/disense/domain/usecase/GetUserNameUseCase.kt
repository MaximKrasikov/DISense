package com.example.disense.domain.usecase

import com.example.disense.domain.models.UserName
import com.example.disense.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor( val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }

}