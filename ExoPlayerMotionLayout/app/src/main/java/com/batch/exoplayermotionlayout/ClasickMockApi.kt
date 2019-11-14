package com.batch.exoplayermotionlayout

import com.batch.exoplayermotionlayout.model.Music
import retrofit2.http.GET

interface ClasickMockApi {
    @GET("musics")
    suspend fun getMusics(): List<Music>
}