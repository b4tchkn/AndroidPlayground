package com.batch.compose_practice.ui.instagram_home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.batch.compose_practice.R
import com.batch.compose_practice.ui.theme.instagramGradient
import com.batch.compose_practice.ui.theme.typography
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Composable
fun InstagramHomePostItem(post: Post) {
    val parentMaxWidth = Modifier
    Column(modifier = Modifier.fillMaxWidth()) {
        AccountInfoSection(post = post)
        ImageSliderSection(postImageResourceIds = post.imageResourceIds, modifier = parentMaxWidth)
        ButtonsSection()
        if (post.likedAccountIds.isNotEmpty()) LikeInfoSection(post = post)
        ContentBody(post = post)

    }
}

@Composable
private fun AccountInfoSection(post: Post) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = post.accountIconImageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.linearGradient(
                            colors = instagramGradient,
                            start = Offset(
                                0f,
                                0f
                            ),
                            end = Offset(
                                100f,
                                100f
                            )
                        )
                    )
                )
        )
        Text(
            text = post.accountId,
            style = typography.body1,
            modifier = Modifier
                .padding(start = 4.dp)
                .weight(1f),
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_more_vert),
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun ImageSliderSection(postImageResourceIds: List<Int>, modifier: Modifier) {
    LazyRow {
        items(postImageResourceIds) { imageResourceId ->
            Image(
                modifier = modifier.height(400.dp),
                painter = painterResource(id = imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
//
//        item {
//            Image(
//                painter = painterResource(id = postImageResourceIds[1]),
//                contentDescription = null,
//                modifier = Modifier
//                    .height(440.dp)
//                    .fillMaxWidth(),
//                contentScale = ContentScale.Crop,
//            )
//        }
//        items(postImageResourceIds) {
//            Image(
//                painter = painterResource(id = it),
//                contentDescription = null,
//                modifier = Modifier
//                    .height(440.dp)
//                    .fillMaxWidth(),
//                contentScale = ContentScale.Crop,
//            )
//        }
    }
}

@Composable
private fun ButtonsSection() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border),
                contentDescription = null
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_speech_bubble),
                contentDescription = null
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_bookmark_border),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun LikeInfoSection(post: Post) {
    Text(
        text =
        if (post.likeCount == 1)
            stringResource(
                id = R.string.instagram_home_post_item_like_info_section_info_only_one,
                post.likedAccountIds.first(),
            )
        else stringResource(
            id = R.string.instagram_home_post_item_like_info_section_info_multi,
            post.likedAccountIds.first(),
        ),
        style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}

@Composable
private fun ContentBody(post: Post) {
    Text(
        text = "${post.accountId} ${post.body}",
        style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
    Text(
        text = stringResource(
            id = R.string.instagram_home_post_item_content_body,
            post.replies.size,
        ),
        style = MaterialTheme.typography.body2,
        color = colorResource(id = R.color.lightGrey),
        modifier = Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
            .clickable { }
    )
    Text(
        text = convertTime(postedAt = post.postedAt),
        style = MaterialTheme.typography.overline,
        color = colorResource(id = R.color.lightGrey),
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}

private fun convertTime(postedAt: String): String {
    val date = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPAN).parse(postedAt) ?: return ""
    val now = Date()

    var passedTimes = TimeUnit.MILLISECONDS.toHours(now.time - date.time)
    var passedText = passedTimes.toString() + "時間前"
    if (passedTimes > 24) {
        passedTimes = TimeUnit.MILLISECONDS.toDays(now.time - date.time)
        passedText = passedTimes.toString() + "日前"
    }
    return passedText
}