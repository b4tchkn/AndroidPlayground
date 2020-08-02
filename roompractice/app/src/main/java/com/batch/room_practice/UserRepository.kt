package com.batch.room_practice

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UserRepository {

    private val userDao = UserDatabase.getInstance().getUserDao()

    fun getUsers(): List<User> {
        var users = listOf<User>()

        // これだとusersに値が入る前にreturnされてしまうのでrunBlockingを使っている
//        CoroutineScope(Dispatchers.IO).launch {
//            users = userDao.getAllUser()
//        }

        runBlocking(Dispatchers.IO) {
            users = userDao.getAllUser()
        }
        return users
    }


    fun insertUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(user)
        }
    }
}