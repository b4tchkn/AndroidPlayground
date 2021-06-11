package com.batch.compose_practice

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.batch.compose_practice.ui.*
import com.batch.compose_practice.ui.animation.AnimationScreen
import com.batch.compose_practice.ui.count_up.CountUpScreen
import com.batch.compose_practice.ui.instagram_home.InstagramHomeScreen
import com.batch.compose_practice.ui.local_composition.CompositionLocalScreen
import com.batch.compose_practice.ui.local_composition.CompositionLocalViewModel
import com.batch.compose_practice.ui.local_composition.compositionLocalViewModelProviderValue
import com.batch.compose_practice.ui.main.HomeScreen
import com.batch.compose_practice.ui.theme.ComposepracticeTheme

@ExperimentalAnimationApi
@Composable
fun ComposePracticeApp() {
    val navController = rememberNavController()
    ComposepracticeTheme {
        NavHost(navController = navController, startDestination = HOME) {
            composable(HOME) {
                HomeScreen(navController = navController)
            }
            composable(COUNT_UP) {
                CountUpScreen(navController = navController)
            }
            composable(INSTAGRAM_HOME) {
                InstagramHomeScreen(navController = navController)
            }
            composable(ANIMATION) {
                AnimationScreen(navController = navController)
            }
            composable(NAVIGATION) {
                NavigationScreen(navController = navController)
            }
            composable(COMPOSITION_LOCAL) {
                CompositionLocalProvider(
                    compositionLocalViewModelProviderValue(
                        CompositionLocalViewModel()
                    )
                ) {
                    CompositionLocalScreen(navController = navController)
                }
            }
        }
    }
}