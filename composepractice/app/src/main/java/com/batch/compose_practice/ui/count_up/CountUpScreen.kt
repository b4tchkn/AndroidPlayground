package com.batch.compose_practice.ui.count_up

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.batch.compose_practice.R

@Composable
fun CountUpScreen(navController: NavController) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.count_up_title)
            TopAppBar(title = { Text(text = title) })
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            Text(text = "Hello")
        }
    }
}