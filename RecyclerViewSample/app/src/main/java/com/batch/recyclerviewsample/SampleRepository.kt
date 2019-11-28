package com.batch.recyclerviewsample

import com.batch.recyclerviewsample.model.Music
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class SampleRepository(baseURL: String) : SampleApi {
    private val apiClient = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()
        .create(SampleApi::class.java)

    override suspend fun getMusics(): List<Music> {
        return apiClient.getMusics()
    }
}