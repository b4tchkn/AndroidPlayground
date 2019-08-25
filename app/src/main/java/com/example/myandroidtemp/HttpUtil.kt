package com.example.myandroidtemp

import okhttp3.OkHttpClient
import okhttp3.Request

class HttpUtil {
    fun httpGET1(url: String): String? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()
        val body = response.body?.string()
        return body
    }
}