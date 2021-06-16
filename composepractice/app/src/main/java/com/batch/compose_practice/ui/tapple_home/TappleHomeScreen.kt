package com.batch.compose_practice.ui.tapple_home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.batch.compose_practice.R
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun TappleHomeScreen() {
    Scaffold(
        backgroundColor = Color.White
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopContent()
            SwipeableCardContent()
            BottomContent()
        }
    }
}

@Composable
private fun TopContent() {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .height(92.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
    ) {
        TextButton(onClick = { }) {
            Text(
                text = "おすすめ",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "|",
            fontSize = 20.sp,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 6.dp)
        )
        TextButton(onClick = { }) {
            Text(
                text = "相手から",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
private fun SwipeableCardContent() {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    var isCentering by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .padding(horizontal = 8.dp)
            .height(540.dp)
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragEnd = {
                        if (!isCentering) {
                            offsetX = 0f
                            offsetY = 0f
                        }
                    },
                ) { change, dragAmount ->
                    change.consumeAllChanges()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                    isCentering = offsetX == 0f && offsetY == 0f
                }
            },
        shape = RoundedCornerShape(24.dp)
    ) {
        val images = listOf(R.drawable.post_image_1, R.drawable.post_image_2, R.drawable.post_image_3)
        Canvas(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            drawIntoCanvas {
                val gradientShader = LinearGradientShader(
                    from = Offset(size.width, 0f),
                    to = Offset(size.width, size.height),
                    colors = listOf(Color.White, Color.DarkGray),
                )
                val brush = ShaderBrush(shader = gradientShader)
                drawRect(brush, Offset(0f, 0f), size)
            }
        }
        Image(
            painter = painterResource(id = images[0]),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "ああああ", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "25歳・静岡", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Row {
                CategoryBadge(label = "おにぎり")
                Spacer(modifier = Modifier.width(4.dp))
                CategoryBadge(label = "ぽいんてぃ")
                Spacer(modifier = Modifier.width(4.dp))
                CategoryBadge(label = "ほげほげ")
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                CategoryBadge(label = "ミス静大")
                Spacer(modifier = Modifier.width(4.dp))
                CategoryBadge(label = "サボテン")
                Spacer(modifier = Modifier.width(4.dp))
                CategoryBadge(label = "夜食")
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_up),
                contentDescription = null,
                tint = Color.Gray
            )
            Text(text = "詳しく見る", color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun BottomContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_menu),
                contentDescription = null,
                Modifier.size(32.dp)
            )
        }
        Row {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_rotate_left),
                    contentDescription = null,
                    Modifier.size(48.dp)
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    Modifier.size(32.dp)

                )
            }
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    Modifier.size(48.dp)
                )
            }
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_work_outline),
                contentDescription = null,
                Modifier.size(32.dp)
            )
        }
    }
}

@Composable
private fun CategoryBadge(label: String) {
    Box(
        modifier = Modifier
            .background(color = Color.Gray.copy(alpha = 0.7f), shape = CircleShape)
            .padding(horizontal = 12.dp, vertical = 8.dp),
    ) {
        Text(text = label, fontSize = 14.sp)
    }
}