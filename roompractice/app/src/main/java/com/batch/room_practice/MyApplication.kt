package com.batch.room_practice

import android.app.Application
import android.util.Log

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        UserDatabase.init(applicationContext)
        Log.d("SMAP", "Database initされた")
    }
}