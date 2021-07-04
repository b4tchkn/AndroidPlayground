package com.batch.compose_practice.ui.tiktok

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
    ) {
        VerticalPager(state = pagerState) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberCoilPainter(request = images[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(text = "aaa")
                Text(text = "aaa")
                Text(text = "ああああ")
            }
        }
    }
}