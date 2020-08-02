package com.batch.room_practice

class UserRepository {

    private val userDao = UserDatabase.getInstance().getUserDao()

    suspend fun getUsers(): List<User> = userDao.getAllUser()


    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

}