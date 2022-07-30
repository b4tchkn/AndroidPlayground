package com.example.composeapp.ui.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.state.SampleState
import com.example.composeapp.state.Sample2State
import com.example.composeapp.ui.Coordinator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SamplePageCoordinator(
    sampleState: SampleState = viewModel(),
    sampleState2: Sample2State = viewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "ComposeApp")
            }
        },
    ) {
        Coordinator(states = listOf(sampleState.state, sampleState2.state)) {
            Column {
                Text(text = sampleState.state.value?.data.toString())
                Text(text = sampleState2.state.value?.data.toString())
            }
        }
    }
}

