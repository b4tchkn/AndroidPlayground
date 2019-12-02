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
        calc_button.setOnClickListener { 
            calc()
        }
    }

    override fun onStart() {
        super.onStart()
        if (myService == null) {
            val it = Intent("myservice")
            it.setPackage("com.batch.aidlserver")
            bindService(it, connection, Context.BIND_AUTO_CREATE)
            Log.d("taguuu", "onStart end")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }

    private fun calc() {
        val num1 = val1_edit_text.text.toString()
        val num2 = val2__edit_text.text.toString()
        try {
            val result = myService?.getResult(num1.toInt(), num2.toInt())
            result_text.text = result.toString()
        } catch (e: RemoteException) {
            e.printStackTrace()
            Log.d("taguuu", e.toString())
        }
    }
}
