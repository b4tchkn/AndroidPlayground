package com.batch.aidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.batch.IMyService
import kotlinx.coroutines.*

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    private val binder: IMyService.Stub = object : IMyService.Stub() {
        override fun getOtenki(): String {
            var result = "デフォルトメッセージ"
            val api = MyServiceRepository("http://weather.livedoor.com/forecast/webservice/json/")
            CoroutineScope(Dispatchers.Default).launch {
                try {
                    val otenki = api.getOtenki("017010")
                    result = otenki.description.text
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            Thread.sleep(700)
            return result
        }

        override fun getCalc(val1: Int, val2: Int): Int {
            return val1 + val2
        }
    }
}