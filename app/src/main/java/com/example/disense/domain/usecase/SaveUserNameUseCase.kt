package com.example.disense.domain.usecase

import com.example.disense.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute( params: SaveUserNameParam) : Boolean{
        if(params.name.isEmpty()) return false
        return true
    }
}