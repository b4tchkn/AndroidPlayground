package com.batch.compose_practice.ui.tiktok

data class Post(
    val video: String,
    val bgmTitle: String,
    val bgmJacket: String,
    val accountId: String,
    val description: String,
    val likeCounts: String,
    val commentCounts: String,
    val shareCounts: String,
) {
    companion object {
        val data = listOf(
            Post(
                video = "t1.mp4",
                bgmTitle = "オリジナル楽曲１ータイトルタイトル",
                bgmJacket = "https://pbs.twimg.com/profile_images/977229272589877248/tvazqbxS.jpg",
                accountId = "アカウント名１",
                description = "説明です。説明です。説明です。",
                likeCounts = "24.1k",
                commentCounts = "12k",
                shareCounts = "3.1k"
            ),
            Post(
                video = "t2.mp4",
                bgmTitle = "オリジナル楽曲２ータイトルタイトル",
                bgmJacket = "https://musubiyori.com/wp-content/uploads/2017/05/mike1.jpg",
                accountId = "アカウント名２",
                description = "説明です。説明です。説明です。",
                likeCounts = "24.1k",
                commentCounts = "12k",
                shareCounts = "3.1k"
            ),
            Post(
                video = "t3.mp4",
                bgmTitle = "オリジナル楽曲３ータイトルタイトル",
                bgmJacket = "https://greenapple-room.com/wp/wp-content/themes/Apple_base/images/bsdoc/carousel01.jpg",
                accountId = "アカウント名３",
                description = "説明です。説明です。説明です。",
                likeCounts = "24.1k",
                commentCounts = "12k",
                shareCounts = "3.1k"
            ),
        )
    }
}
