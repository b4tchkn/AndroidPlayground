package com.batch.itarchkadai3

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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var myservice: IMyAidlInterface? = null

    private val connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            myservice = IMyAidlInterface.Stub.asInterface(service)
            Toast.makeText(applicationContext, "Service Connected", Toast.LENGTH_SHORT).show()
        }

        override fun onServiceDisconnected(name: ComponentName) {
            myservice = null
            Toast.makeText(applicationContext, "Service Disconnected", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calc_button.setOnClickListener {
            val num1 = val1_edit_text.text.toString()
            val num2 = val2__edit_text.text.toString()
            try {
                val result = myservice?.getResult(num1.toInt(), num2.toInt())
                result_text.text = result.toString()
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (myservice == null) {
            val intent = Intent(this, MyAidlService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }
}
