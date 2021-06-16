package com.batch.compose_practice.ui.instagram_home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.batch.compose_practice.ui.theme.instagramGradient

@Composable
fun InstagramHomeStorySection(stories: List<Post>) {
    LazyRow(Modifier.padding(vertical = 8.dp)) {
        items(stories) {
            Box(modifier = Modifier.padding(horizontal = 4.dp)) {
                Image(
                    painter = painterResource(id = it.accountIconImageResourceId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
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
            }
        }
    }
}