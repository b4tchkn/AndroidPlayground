package com.batch.compose_practice.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.batch.compose_practice.R
import com.batch.compose_practice.ui.*

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
            item {
                MainPracticeSectionItem(
                    sectionTitle = stringResource(id = R.string.home_navigation_section_title),
                    navigateTo = { navController.navigate(NAVIGATION) })
            }
            item {
                MainPracticeSectionItem(
                    sectionTitle = stringResource(id = R.string.composition_local_title),
                    navigateTo = { navController.navigate(COMPOSITION_LOCAL) }
                )
            }
            item {
                MainPracticeSectionItem(
                    sectionTitle = "TappleHome",
                    navigateTo = { navController.navigate(TAPPLE_HOME) }
                )
            }
            item {
                MainPracticeSectionItem(
                    sectionTitle = stringResource(id = R.string.android_view_sample_title),
                    navigateTo = { navController.navigate(ANDROID_VIEW_SAMPLE) }
                )
            }
            item {
                MainPracticeSectionItem(
                    sectionTitle = stringResource(id = R.string.tiktok_title),
                    navigateTo = { navController.navigate(TIKTOK) }
                )
            }
        }
    }
}