package com.batch.coroutine_sample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int>
        get() = _count

    private val _count10Event = MutableSharedFlow<Boolean>()
    val count10Event: SharedFlow<Boolean>
        get() = _count10Event

    private val _testSharedFlow = MutableSharedFlow<Int>()
    val testSharedFlow: SharedFlow<Int>
        get() = _testSharedFlow

    fun incrementCounter() {
        _count.value++
        if (_count.value == 10) {
            viewModelScope.launch {
                Log.d("count10Event", "Event流すぞ！")
                _count10Event.emit(true)
            }
        } else {
            viewModelScope.launch {
                _count10Event.emit(false)
            }
        }
    }

    fun testFlow(): Flow<Int> {
        return flow {
            for (i in 1..5) {
                Log.d("testFlow", "値流す$i")
                emit(i)
                kotlinx.coroutines.delay(300)
            }
        }
    }

    fun testSharedFlow() {
        viewModelScope.launch {
            _testSharedFlow.emit(0)
        }
    }
}