package com.batch.recyclerviewsample.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Music (
    val name: String,
    val description: String,
    @Json(name = "cover_path")
    val coverPath: String
): Parcelable