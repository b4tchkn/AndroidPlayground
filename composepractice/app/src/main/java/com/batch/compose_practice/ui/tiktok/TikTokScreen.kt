package com.batch.compose_practice.ui.tiktok

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.batch.compose_practice.R
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun TikTokScreen() {
    val images = listOf(
        "https://instagrammernewsimg.s3.ap-northeast-1-ntt.wasabisys.com/B-uBwCoB_ie",
        "https://pbs.twimg.com/profile_images/643873688132128769/bfgPCB1l_400x400.jpg",
        "https://instagrammernewsimg.s3.ap-northeast-1-ntt.wasabisys.com/B3uVixCHf5t",
        "https://247lingerie.co/Contents/ProductImages/0/3g90196_L.jpg",
    )

    val pagerState = rememberPagerState(pageCount = images.size)
    val animateRotation = remember {
        Animatable(0f)
    }
    val musicTextScrollState = rememberScrollState()

    LaunchedEffect("repeatable") {
        animateRotation.animateTo(
            360f,
            animationSpec = infiniteRepeatable(
                animation = tween(3000, easing = LinearEasing)
            )
        )
    }

    LaunchedEffect(key1 = "horizontal") {
        musicTextScrollState.animateScrollTo(
            musicTextScrollState.maxValue,
            animationSpec = infiniteRepeatable(
                animation = tween(8000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart,
            )
        )
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberCoilPainter(request = images[it]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        ActionButtons(animateRotation = animateRotation)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, bottom = 16.dp, end = 80.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "@アカウント名",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "説明説明説明説明説明説明説明説明説明説明",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_music_note),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .width(180.dp)
                        .horizontalScroll(musicTextScrollState, enabled = false),
                    text = "曲名曲名曲名曲名曲名曲名曲名曲名曲名曲名曲名曲名。",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    ),
                    maxLines = 1,
                )
            }
        }
    }
}

@Composable
private fun ActionButtons(animateRotation: Animatable<Float, AnimationVector1D>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 16.dp, bottom = 48.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {
                    // do nothing
                }
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_favorite),
                    contentDescription = null,
                )
            }
            Text(text = "13.3k", style = TextStyle(color = Color.White, fontSize = 14.sp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {
                    // do nothing
                }
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_mode_comment),
                    contentDescription = null,
                )
            }
            Text(text = "3.3k", style = TextStyle(color = Color.White, fontSize = 14.sp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {
                    // do nothing
                }
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_reply),
                    contentDescription = null,
                )
            }
            Text(text = "1.3k", style = TextStyle(color = Color.White, fontSize = 14.sp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier.rotate(animateRotation.value),
            painter = painterResource(
                id = R.drawable.ic_baseline_arrow_back
            ),
            contentDescription = null,
        )
    }
}