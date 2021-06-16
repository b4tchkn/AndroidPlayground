package com.batch.compose_practice.ui.instagram_home

import com.batch.compose_practice.R

object PostDataSource {
    fun generateStoryData(): List<Post> = listOf(
        Post(
            accountIconImageResourceId = R.drawable.user01,
            accountId = "userId01",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user02,
            accountId = "userId02",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user03,
            accountId = "userId03",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user04,
            accountId = "userId04",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user01,
            accountId = "userId01",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user02,
            accountId = "userId02",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user03,
            accountId = "userId03",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user04,
            accountId = "userId04",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
            ),
            likeCount = 40,
            replies = listOf(
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
    )

    fun generatePostsData(): List<Post> = listOf(
        Post(
            accountIconImageResourceId = R.drawable.user02,
            accountId = "userId02",
            isLike = false,
            isSavedCollection = false,
            body = "おはな",
            postedAt = "2021/06/15 09:10:00",
            imageResourceIds = listOf(
                R.drawable.post_image_4,
                R.drawable.post_image_3,
                R.drawable.post_image_2,
                R.drawable.post_image_1,
            ),
            likeCount = 40,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.user03,
                    accountId = "userId03",
                    body = "ヤッホ〜〜い",
                    postedAt = "2021/06/16 22:30:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.user04,
                    accountId = "userId04",
                    body = "ええやん",
                    postedAt = "2021/06/16 23:00:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user01,
            accountId = "userId01",
            isLike = true,
            isSavedCollection = false,
            body = "にゃんにゃんにゃん",
            postedAt = "2021/06/16 10:00:00",
            imageResourceIds = listOf(R.drawable.post_image_1),
            likeCount = 10,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.user03,
                    accountId = "userId03",
                    body = "いいねえ",
                    postedAt = "2021/06/16 11:00:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.user04,
                    accountId = "userId04",
                    body = "いいね！！！",
                    postedAt = "2021/06/16 19:30:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("userId03", "userId")
        ),
        Post(
            accountIconImageResourceId = R.drawable.user03,
            accountId = "userId03",
            isLike = false,
            isSavedCollection = false,
            body = "いい写真撮れた",
            postedAt = "2021/06/16 22:10:00",
            imageResourceIds = listOf(
                R.drawable.post_image_2,
                R.drawable.post_image_3,
                R.drawable.post_image_1,
            ),
            likeCount = 100,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.user03,
                    accountId = "userId03",
                    body = "ヤッホ〜〜い",
                    postedAt = "2021/06/16 22:30:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.user04,
                    accountId = "userId04",
                    body = "ええやん",
                    postedAt = "2021/06/16 23:00:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("userId04", "userId02", "userId01")
        ),
    )
}