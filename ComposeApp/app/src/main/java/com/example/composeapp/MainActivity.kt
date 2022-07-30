package com.example.composeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.state.SampleState
import com.example.composeapp.state.SampleState2
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SamplePageCoordinator()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SamplePageCoordinator(
    sampleState: SampleState = viewModel(),
    sampleState2: SampleState2 = viewModel(),
) {
    Scaffold(
        topBar = {},
    ) {
        val state by sampleState.state.observeAsState()
        val state2 by sampleState2.state.observeAsState()

        if (state?.data == null && state2?.data == null) {
            CircularProgressIndicator()
        } else {
            Column {
                Text(text = state?.data.toString())
                Text(text = state2?.data.toString())
            }

        }
    }
}
