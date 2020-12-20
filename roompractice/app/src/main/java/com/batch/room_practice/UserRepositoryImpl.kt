package com.batch.room_practice

import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl : UserRepository{
    private val userDao = MyApplication.userDatabase.getUserDao()
    override fun getUsers(): Flow<List<User>> = userDao.getAllUser()
    override suspend fun insertUser(user: User) {
        userDao.insert(user)
    }
}