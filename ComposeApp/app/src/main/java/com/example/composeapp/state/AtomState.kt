package com.example.composeapp.state

import androidx.compose.runtime.Stable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.composeapp.model.UiModel

@Stable
abstract class AtomState<T> : ViewModel() {
    abstract val state: LiveData<UiModel<T>>

    abstract suspend fun fetch()
}
