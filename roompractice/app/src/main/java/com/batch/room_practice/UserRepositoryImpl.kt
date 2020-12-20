package com.batch.room_practice

import androidx.lifecycle.LiveData

class UserRepositoryImpl : UserRepository{
    private val userDao = MyApplication.userDatabase.getUserDao()
    override fun getUsers(): LiveData<List<User>> = userDao.getAllUser()
    override suspend fun insertUser(user: User) {
        userDao.insert(user)
    }
}