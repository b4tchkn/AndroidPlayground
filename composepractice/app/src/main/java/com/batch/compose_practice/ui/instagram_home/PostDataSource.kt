package com.batch.compose_practice.ui.instagram_home

import com.batch.compose_practice.R

object PostDataSource {
    fun generatePostsData(): List<Post> = listOf(
        Post(
            accountIconImageResourceId = R.drawable.account_icon_image_batch,
            accountId = "b4tchkn",
            isLike = true,
            isSavedCollection = false,
            body = "にゃんにゃんにゃん",
            postedAt = "2021/03/14 10:00:00",
            imageResourceIds = listOf(R.drawable.post_image_1),
            likeCount = 10,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_horis,
                    accountId = "horis0202",
                    body = "いいねえ",
                    postedAt = "2021/03/14 11:00:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_zoo,
                    accountId = "zoo_the_zoo",
                    body = "いいね！！！",
                    postedAt = "2021/03/15 19:30:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("horis0202", "01atsu")
        ),
        Post(
            accountIconImageResourceId = R.drawable.account_icon_image_messi,
            accountId = "01atsu",
            isLike = false,
            isSavedCollection = false,
            body = "messiです",
            postedAt = "2021/03/21 8:10:00",
            imageResourceIds = listOf(
                R.drawable.post_image_2,
                R.drawable.post_image_3,
                R.drawable.post_image_1,
            ),
            likeCount = 100,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_horis,
                    accountId = "horis0202",
                    body = "ヤッホ〜〜い",
                    postedAt = "2021/03/21 13:00:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_zoo,
                    accountId = "zoo_the_zoo",
                    body = "ええやん",
                    postedAt = "2021/03/21 15:45:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("zoo_the_zoo", "01atsu")
        ),
        Post(
            accountIconImageResourceId = R.drawable.account_icon_image_batch,
            accountId = "b4tchkn",
            isLike = true,
            isSavedCollection = false,
            body = "にゃんにゃんにゃん",
            postedAt = "2021/03/14 10:00:00",
            imageResourceIds = listOf(R.drawable.post_image_1),
            likeCount = 10,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_horis,
                    accountId = "horis0202",
                    body = "いいねえ",
                    postedAt = "2021/03/14 11:00:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_zoo,
                    accountId = "zoo_the_zoo",
                    body = "いいね！！！",
                    postedAt = "2021/03/15 19:30:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("horis0202", "01atsu")
        ),
        Post(
            accountIconImageResourceId = R.drawable.account_icon_image_messi,
            accountId = "01atsu",
            isLike = false,
            isSavedCollection = false,
            body = "messiです",
            postedAt = "2021/03/21 8:10:00",
            imageResourceIds = listOf(
                R.drawable.post_image_2,
                R.drawable.post_image_3,
                R.drawable.post_image_1,
            ),
            likeCount = 100,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_horis,
                    accountId = "horis0202",
                    body = "ヤッホ〜〜い",
                    postedAt = "2021/03/21 13:00:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_zoo,
                    accountId = "zoo_the_zoo",
                    body = "ええやん",
                    postedAt = "2021/03/21 15:45:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("zoo_the_zoo", "01atsu")
        ),
        Post(
            accountIconImageResourceId = R.drawable.account_icon_image_batch,
            accountId = "b4tchkn",
            isLike = true,
            isSavedCollection = false,
            body = "にゃんにゃんにゃん",
            postedAt = "2021/03/14 10:00:00",
            imageResourceIds = listOf(R.drawable.post_image_1),
            likeCount = 10,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_horis,
                    accountId = "horis0202",
                    body = "いいねえ",
                    postedAt = "2021/03/14 11:00:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_zoo,
                    accountId = "zoo_the_zoo",
                    body = "いいね！！！",
                    postedAt = "2021/03/15 19:30:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("horis0202", "01atsu")
        ),
        Post(
            accountIconImageResourceId = R.drawable.account_icon_image_messi,
            accountId = "01atsu",
            isLike = false,
            isSavedCollection = false,
            body = "messiです",
            postedAt = "2021/03/21 8:10:00",
            imageResourceIds = listOf(
                R.drawable.post_image_2,
                R.drawable.post_image_3,
                R.drawable.post_image_1,
            ),
            likeCount = 100,
            replies = listOf(
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_horis,
                    accountId = "horis0202",
                    body = "ヤッホ〜〜い",
                    postedAt = "2021/03/21 13:00:00",
                    likeCount = 0,
                ),
                Post.Reply(
                    accountIconImageResourceId = R.drawable.account_icon_image_zoo,
                    accountId = "zoo_the_zoo",
                    body = "ええやん",
                    postedAt = "2021/03/21 15:45:00",
                    likeCount = 1,
                ),
            ),
            likedAccountIds = listOf("zoo_the_zoo", "01atsu")
        ),
    )
}