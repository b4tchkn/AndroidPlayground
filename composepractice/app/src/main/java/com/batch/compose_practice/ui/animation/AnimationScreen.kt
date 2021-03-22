package com.batch.compose_practice.ui.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.batch.compose_practice.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

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
        var visible by remember { mutableStateOf(true) }
        val infiniteTransition = rememberInfiniteTransition()
        val infiniteAnimState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = LinearEasing,
                )
            )
        )

        val animValue by animateFloatAsState(
            targetValue = if (visible) {
                -50f
            } else {
                10f
            },
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessMedium,
            )
        )

        Button(
            onClick = {
                visible = !visible
            }
        ) {
        }

        Icon(
            modifier = Modifier
                .offset(
                    x = animValue.dp,
                    y = 100.dp
                ),
            painter = painterResource(id = R.drawable.ic_baseline_favorite_border),
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .offset(
                    x = animValue.dp,
                    y = 120.dp
                ),
            painter = painterResource(id = R.drawable.ic_baseline_favorite_border),
            contentDescription = null
        )
    }
}
