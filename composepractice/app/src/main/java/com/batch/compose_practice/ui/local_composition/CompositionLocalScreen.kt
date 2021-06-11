package com.batch.compose_practice.ui.local_composition

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.batch.compose_practice.R

@Composable
fun CompositionLocalScreen(navController: NavController) {
    val viewModel = compositionLocalViewModel()
    val count = viewModel.count.collectAsState()
    CompositionLocalStatelessScreen(
        navController = navController,
        count = count.value,
        onCountUpClick = { viewModel.countUp() },
        onCountDownClick = { viewModel.countDown() }
    )
}

@Composable
private fun CompositionLocalStatelessScreen(
    navController: NavController,
    count: Int,
    onCountUpClick: () -> Unit,
    onCountDownClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.composition_local_title)
            TopAppBar(
                title = {
                    Text(text = title)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back),
                            contentDescription = null,
                        )
                    }
                }
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(onClick = onCountDownClick) {
                Text(text = "CountDown")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = count.toString())
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onCountUpClick) {
                Text(text = "CountUp")
            }
        }
    }
}