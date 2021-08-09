package com.batch.compose_practice.ui.tiktok

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.batch.compose_practice.R
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

@Composable
fun TikTokPlayer(context: Context, url: String, selected: Boolean) {
    val mediaItem = MediaItem.fromUri("asset:///$url")

    val tiktokPlayer = remember {
        SimpleExoPlayer.Builder(context)
            .build()
            .apply {
                val mediaSource = ProgressiveMediaSource.Factory(
                    DefaultDataSourceFactory(context, "composePracticeTikTok")
                )
                    .createMediaSource(mediaItem)
                this.setMediaSource(mediaSource)
            }
    }
    tiktokPlayer.playWhenReady = selected
    val isPlaying = remember { mutableStateOf(tiktokPlayer.isPlaying) }
    tiktokPlayer.prepare()
    tiktokPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    tiktokPlayer.repeatMode = Player.REPEAT_MODE_ONE

    val modifier = Modifier.clickable {
        isPlaying.value = tiktokPlayer.playWhenReady
        Log.d("TikTok", "Pause")
        tiktokPlayer.playWhenReady = !tiktokPlayer.isPlaying // Can't work sometime
    }
    Box(modifier = modifier) {
        AndroidView(
            factory = {
                PlayerView(it).apply {
                    useController = false
                    player = tiktokPlayer
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                }
            }
        )
        if (isPlaying.value)
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(100.dp),
                painter = painterResource(
                    id = R.drawable.ic_send
                ),
                contentDescription = null,
            )
    }

    DisposableEffect(url) {
        onDispose {
            tiktokPlayer.release()
        }
    }
}