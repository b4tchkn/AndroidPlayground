package com.batch.compose_practice.ui.local_composition

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CompositionLocalViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int>
        get() = _count

    fun countUp() {
        _count.value++
    }

    fun countDown() {
        _count.value--
    }
}

private val LocalCompositionLocalViewModel = compositionLocalOf<CompositionLocalViewModel> {
    error("not LocalCompositionLocalViewModel")
}

fun compositionLocalViewModelProviderValue(viewModel: CompositionLocalViewModel) =
    LocalCompositionLocalViewModel provides viewModel

@Composable
fun compositionLocalViewModel() = LocalCompositionLocalViewModel.current