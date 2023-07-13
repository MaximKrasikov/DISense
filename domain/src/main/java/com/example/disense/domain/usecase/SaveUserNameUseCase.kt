package com.example.disense.domain.usecase

import com.example.disense.domain.models.SaveUserNameParam
import com.example.disense.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor( val userRepository: UserRepository) {
    fun execute( params: SaveUserNameParam) : Boolean{
        val oldUserName =userRepository.getName()
        if(oldUserName.firstName ==params.name){
            return true
        }

        return userRepository.saveName(saveNameParam =params)
    }
}