package com.batch.exoplayermotionlayout

import com.batch.exoplayermotionlayout.model.Music
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ClasickMockRepository(baseURL: String) : ClasickMockApi {
    private val apiClient = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()
        .create(ClasickMockApi::class.java)

    override suspend fun getMusics(): List<Music> {
        return apiClient.getMusics()
    }
}