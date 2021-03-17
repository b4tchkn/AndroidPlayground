package com.batch.compose_practice.ui.instagram_home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.batch.compose_practice.R

@Composable
fun InstagramHomeScreen(navController: NavController) {
    val viewModel: InstagramHomeViewModel = viewModel()
    val posts by viewModel.posts.collectAsState()
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.home_instagram_home_section_title)
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
        },
    ) {
        viewModel.getPosts()
        LazyColumn {
            items(posts) { post ->
                InstagramHomePostItem(post = post)
            }
        }
    }
}