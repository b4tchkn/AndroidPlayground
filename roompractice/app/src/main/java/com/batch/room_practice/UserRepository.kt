package com.batch.room_practice

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>
    suspend fun insertUser(user: User)
}