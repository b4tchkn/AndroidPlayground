package com.batch.exoplayermotionlayout.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Music(
    val name: String,
    val description: String,
    @Json(name = "cover_path")
    val coverPath: String
)