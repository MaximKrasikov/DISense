package com.example.disense.domain.repository

import com.example.disense.domain.models.SaveUserNameParam
import com.example.disense.domain.models.UserName

interface UserRepository {
    fun saveName(saveNameParam: SaveUserNameParam) : Boolean
    fun getName(): UserName
}