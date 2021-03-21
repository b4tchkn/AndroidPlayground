package com.batch.compose_practice.ui.animation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.batch.compose_practice.R

@ExperimentalAnimationApi
@Composable
fun AnimationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.animation_title)
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(text = title)
                }
            )
        }
    ) {
//        val infiniteTransition = rememberInfiniteTransition()
//        val color by infiniteTransition.animateColor(
//            initialValue = Color.Red,
//            targetValue = Color.Green,
//            animationSpec = infiniteRepeatable(
//                animation = tween(1000, easing = LinearEasing),
//                repeatMode = RepeatMode.Reverse
//            )
//        )
//
//        Box(Modifier.fillMaxSize().background(color))

        val visible by remember { mutableStateOf(true) }
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(
                initialOffsetY = { -40 }
            ) + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Text("Hello", Modifier.fillMaxWidth().height(200.dp))
        }
    }
}
