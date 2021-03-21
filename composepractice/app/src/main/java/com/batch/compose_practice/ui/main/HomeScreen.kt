package com.batch.compose_practice.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.batch.compose_practice.R
import com.batch.compose_practice.ui.ANIMATION
import com.batch.compose_practice.ui.COUNT_UP
import com.batch.compose_practice.ui.INSTAGRAM_HOME

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) }
            )
        }
    ) {
        LazyColumn {
            item {
                MainPracticeSectionItem(
                    sectionTitle = stringResource(id = R.string.home_count_up_section_title),
                    navigateTo = { navController.navigate(COUNT_UP) }
                )
            }
            item {
                MainPracticeSectionItem(
                    sectionTitle = stringResource(id = R.string.home_instagram_home_section_title),
                    navigateTo = { navController.navigate(INSTAGRAM_HOME) }
                )
            }
            item {
                MainPracticeSectionItem(
                    sectionTitle = stringResource(id = R.string.home_animation_section_title),
                    navigateTo = { navController.navigate(ANIMATION) }
                )
            }
        }
    }
}