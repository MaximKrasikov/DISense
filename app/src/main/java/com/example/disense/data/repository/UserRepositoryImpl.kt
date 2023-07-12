package com.example.disense.data.repository

import com.example.disense.data.storage.models.User
import com.example.disense.data.storage.UserStorage
import com.example.disense.domain.models.SaveUserNameParam
import com.example.disense.domain.models.UserName
import com.example.disense.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default name"

    // дата-слой для работы с нетворкингом и стораджом
class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveNameParam: SaveUserNameParam) : Boolean{
        return userStorage.save(User(firstName = saveNameParam.name, lastName = "" ))
    }
    override fun getName(): UserName {
        val user = userStorage.get()

        return  UserName(user.firstName, user.lastName)
    }

}