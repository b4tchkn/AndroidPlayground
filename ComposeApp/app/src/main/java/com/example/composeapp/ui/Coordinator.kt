package com.example.composeapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeapp.state.AtomState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

@Composable
fun Coordinator(
    states: List<AtomState<out Any>>,
    content: @Composable () -> Unit
) {
    val observedState = states.map { it.state.observeAsState().value }
    val hasData = observedState.all { it?.data != null }
    val hasAnyError = observedState.any { it?.error != null }

    val coroutineScope = rememberCoroutineScope()
    val refreshing = remember { mutableStateOf(false) }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing.value),
        onRefresh = {
            coroutineScope.launch {
                refreshing.value = true
                val deferreds = states.map { async { it.fetch() } }
                deferreds.awaitAll()
                refreshing.value = false
            }
        }) {
        if (hasData && !hasAnyError) {
            content()
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                if (hasAnyError)
                    Text(text = "エラーが発生しました。")
                else
                    CircularProgressIndicator()
            }
        }
    }
}