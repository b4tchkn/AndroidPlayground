package com.batch.room_practice

import android.app.Application

class MyApplication : Application() {

    companion object {
        lateinit var userDatabase: UserDatabase
    }
    override fun onCreate() {
        super.onCreate()
        userDatabase = UserDatabase.getInstance(applicationContext)
    }
}