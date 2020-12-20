package com.batch.room_practice

import androidx.lifecycle.LiveData

interface UserRepository {
    fun getUsers(): LiveData<List<User>>
    suspend fun insertUser(user: User)
}