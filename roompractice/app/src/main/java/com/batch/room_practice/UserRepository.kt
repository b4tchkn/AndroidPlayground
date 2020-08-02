package com.batch.room_practice

import androidx.lifecycle.LiveData

class UserRepository {

    private val userDao = MyApplication.userDatabase.getUserDao()

    fun getUsers(): LiveData<List<User>> = userDao.getAllUser()

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

}