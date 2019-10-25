package com.batch.itarchkadai2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// kadai2-4
class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // バッテリーの値が変更したとき，Toastを表示
        Toast.makeText(context, "battery changed", Toast.LENGTH_SHORT).show()
    }
}