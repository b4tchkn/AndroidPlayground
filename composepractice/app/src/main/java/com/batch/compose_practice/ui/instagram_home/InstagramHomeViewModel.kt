package com.batch.compose_practice.ui.instagram_home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InstagramHomeViewModel(

) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(listOf())
    val posts: StateFlow<List<Post>>
        get() = _posts

    fun getPosts() {
        _posts.value = PostDataSource.generatePostsData()
    }
}