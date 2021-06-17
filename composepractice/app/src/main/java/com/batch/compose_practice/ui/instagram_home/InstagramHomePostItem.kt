package com.batch.compose_practice.ui.instagram_home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.batch.compose_practice.R
import com.batch.compose_practice.ui.theme.instagramGradient
import com.batch.compose_practice.ui.theme.typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@ExperimentalPagerApi
@Composable
fun InstagramHomePostItem(post: Post) {
    val pagerState = rememberPagerState(pageCount = post.imageResourceIds.size)
    Column(modifier = Modifier.fillMaxWidth()) {
        AccountInfoSection(post = post)
        ImageSliderSection(pagerState = pagerState, postImageResourceIds = post.imageResourceIds)
        Box(modifier = Modifier.fillMaxWidth()) {
            ButtonsSection()
            if (pagerState.pageCount > 1)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Indicators(
                        currentPosition = pagerState.currentPage,
                        contentCount = pagerState.pageCount,
                    )
                }
        }
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

@ExperimentalPagerApi
@Composable
private fun ImageSliderSection(pagerState: PagerState, postImageResourceIds: List<Int>) {
    Box {
        HorizontalPager(state = pagerState) {
            Image(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = postImageResourceIds[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
        if (postImageResourceIds.size > 1)
            ImageCountBadge(
                current = pagerState.currentPage + 1,
                maxCount = pagerState.pageCount
            )
    }
}

@Composable
private fun ImageCountBadge(current: Int, maxCount: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        Text(
            text = "$current/$maxCount",
            modifier = Modifier
                .width(36.dp)
                .height(24.dp)
                .background(
                    Color.DarkGray.copy(alpha = 0.7f),
                    shape = CircleShape,
                )
                .padding(vertical = 4.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
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
private fun Indicators(currentPosition: Int, contentCount: Int) {
    Row(
        modifier = Modifier.width((12 * contentCount).dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        repeat(contentCount) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(shape = CircleShape)
                    .background(color = if (currentPosition == it) Color(0xFF4382D3) else Color.Gray),
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