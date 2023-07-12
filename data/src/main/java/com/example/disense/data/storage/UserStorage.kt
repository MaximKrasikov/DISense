package com.example.disense.data.storage

import com.example.disense.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}