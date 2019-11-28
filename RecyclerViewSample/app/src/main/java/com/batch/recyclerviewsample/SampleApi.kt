package com.batch.recyclerviewsample

import com.batch.recyclerviewsample.model.Music
import retrofit2.http.GET

interface SampleApi {
    @GET("musics")
    suspend fun getMusics(): List<Music>
}