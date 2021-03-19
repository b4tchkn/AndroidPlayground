package com.batch.compose_practice.ui.instagram_home

data class Post(
    val accountIconImageResourceId: Int,
    val accountId: String,
    val isLike: Boolean,
    val isSavedCollection: Boolean,
    val replies: List<Reply>,
    val body: String,
    val postedAt: String,
    val imageResourceIds: List<Int>,
    val likeCount: Int,
    val likedAccountIds: List<String>,
) {
    data class Reply(
        val accountIconImageResourceId: Int,
        val accountId: String,
        val body: String,
        val postedAt: String,
        val likeCount: Int,
    )
}