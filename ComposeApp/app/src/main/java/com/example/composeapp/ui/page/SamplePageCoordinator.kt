package com.example.composeapp.ui.page

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.state.Sample2State
import com.example.composeapp.state.SampleState
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
        Coordinator(states = listOf(sampleState, sampleState2)) {
            SamplePage(
                sample = sampleState.state.observeAsState().value!!.data!!,
                sample2 = sampleState2.state.observeAsState().value!!.data!!,
            )
        }
    }
}

