package com.batch.compose_practice

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.batch.compose_practice.ui.main.MainPracticeSectionItem
import com.batch.compose_practice.ui.theme.ComposepracticeTheme

@Composable
fun ComposePracticeApp() {
    ComposepracticeTheme {
        AppContent()
    }
}

@Composable
private fun AppContent() {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) }
            )
        },
        content = {
            LazyColumn {
                item {
                    MainPracticeSectionItem(
                        sectionTitle = stringResource(id = R.string.count_up_section_title),
                        navigateTo = { /*TODO*/ })
                }
                item { }
            }
        }
    )
}