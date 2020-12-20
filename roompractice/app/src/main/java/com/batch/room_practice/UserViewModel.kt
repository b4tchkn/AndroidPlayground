package com.batch.room_practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val repository = UserRepositoryImpl()

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>>
        get() = _users

    init {
        viewModelScope.launch {
            repository.getUsers().collect { users ->
                _users.value = users
            }
        }
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}