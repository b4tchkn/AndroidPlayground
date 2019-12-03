package com.batch.aidlclient

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.batch.IMyService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var myService: IMyService? = null

    private val connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            myService = IMyService.Stub.asInterface(service)
            Toast.makeText(applicationContext, "Service Connected", Toast.LENGTH_SHORT).show()
        }

        override fun onServiceDisconnected(name: ComponentName) {
            myService = null
            Toast.makeText(applicationContext, "Service Disconnected", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        otenki_button.setOnClickListener {
            getOtenki()
            getCalc()
        }
    }

    override fun onStart() {
        super.onStart()
        if (myService == null) {
            val it = Intent("myservice")
            it.setPackage("com.batch.aidlserver")
            bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }

    private fun getOtenki() {
        try {
            val result = myService?.getOtenki()
            if (result != null) Toast.makeText(applicationContext, "データを取得しました", Toast.LENGTH_SHORT).show()
            else Toast.makeText(applicationContext, "データの取得に失敗しました", Toast.LENGTH_SHORT).show()
            otenki_title.text = result?.get(0)
            otenki_description.text = result?.get(1)
        } catch (e: RemoteException) {
            e.printStackTrace()
            Log.d("taguuu", e.toString())
        }
    }

    private fun getCalc() {
        val num1 = 3
        val num2 = 4
        try {
            val result = myService?.getCalc(num1, num2)
            Log.d("taguuu", result.toString())
        } catch (e: RemoteException) {
            e.printStackTrace()
            Log.d("taguuu", e.toString())
        }
    }
}
