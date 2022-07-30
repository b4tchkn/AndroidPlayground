package com.example.composeapp.ui

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import com.example.composeapp.model.UiModel

@Composable
fun Coordinator(
    states: List<MutableLiveData<out UiModel<out Any>>>,
    content: @Composable () -> Unit
) {
    val observedState = states.map { it.observeAsState().value }
    val hasData = observedState.all { it?.data != null }
    val hasAnyError = observedState.any { it?.error != null }

    if (hasData && !hasAnyError) {
        content()
    } else if (hasAnyError) {
        Text(text = "エラーが発生しました。")
    } else {
        CircularProgressIndicator()
    }

}