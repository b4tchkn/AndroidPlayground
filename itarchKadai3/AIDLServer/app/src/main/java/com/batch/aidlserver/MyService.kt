package com.batch.aidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    private val binder: IMyService.Stub = object : IMyService.Stub() {
        override fun getResult(val1: Int, val2: Int): Int {
            return val1 + val2
        }
    }
}