package com.batch.compose_practice.ui.count_up

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CountUpViewModel : ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int>
        get() = _count


    fun countUp() {
        _count.value += 1
    }
}