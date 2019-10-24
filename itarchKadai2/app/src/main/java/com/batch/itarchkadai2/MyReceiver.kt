package com.batch.itarchkadai2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// kadai2-4
class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "battery", Toast.LENGTH_LONG).show()
    }
}