package com.batch.aidlserver

import retrofit2.http.GET
import retrofit2.http.Query

interface OtenkiApi {
    @GET("v1")
    suspend fun getOtenki(
        @Query("city") city: String
    ): Otenki
}