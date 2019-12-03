package com.batch.aidlserver

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MyServiceRepository(baseURL: String) : OtenkiApi {

    private val apiClient = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()
        .create(OtenkiApi::class.java)

    override suspend fun getOtenki(city: String): Otenki {
        return apiClient.getOtenki(city)
    }
}