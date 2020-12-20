package com.batch.room_practice

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {


    val users: LiveData<List<User>> = UserRepositoryImpl().getUsers()
    private val repository = UserRepositoryImpl()

    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}