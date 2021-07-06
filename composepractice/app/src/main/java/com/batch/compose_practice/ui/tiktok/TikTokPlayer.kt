package com.batch.compose_practice.ui.tiktok

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

@Composable
fun TikTokPlayer(modifier: Modifier, context: Context, url: String, selected: Boolean) {
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
    tiktokPlayer.prepare()
    tiktokPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    tiktokPlayer.repeatMode = Player.REPEAT_MODE_ONE
    AndroidView(
        modifier = modifier,
        factory = {
            PlayerView(it).apply {
                useController = false
                player = tiktokPlayer
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        }
    )
    tiktokPlayer.playWhenReady = true

    DisposableEffect(url) {
        onDispose {
            tiktokPlayer.release()
        }
    }
}