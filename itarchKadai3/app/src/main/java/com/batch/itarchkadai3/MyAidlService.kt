package com.batch.itarchkadai3

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException

class MyAidlService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    private val binder: IMyAidlInterface.Stub = object : IMyAidlInterface.Stub() {
//        @Throws(RemoteException::class)
        override fun getResult(val1: Int, val2: Int): Int {
            return val1 * val2
        }
    }
}