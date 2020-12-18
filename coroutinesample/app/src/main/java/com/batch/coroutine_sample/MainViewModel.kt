package com.batch.coroutine_sample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int>
        get() = _count

    private val _count10Event = MutableSharedFlow<Boolean>()
    val count10Event: SharedFlow<Boolean>
        get() = _count10Event

    fun incrementCounter() {
        _count.value++
        if (_count.value == 10) {
            viewModelScope.launch {
                Log.d("yahoooo", "Event流すぞ！")
                _count10Event.emit(true)
            }
        }
    }

    fun sendSharedFlowEvent() {
        viewModelScope.launch {
            _count10Event.emit(true)
        }
    }
}