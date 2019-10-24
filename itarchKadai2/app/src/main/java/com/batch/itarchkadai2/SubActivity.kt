package com.batch.itarchkadai2

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    private lateinit var receiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        // kadai2-3
        val intentText = intent.getStringExtra("gotoSubActivity")
        Toast.makeText(this, intentText, Toast.LENGTH_LONG).show()
        // kadai2-2
        intentButton.setOnClickListener {
            val intent =
                Intent("android.intent.action.VIEW", Uri.parse(urlEditText.text.toString()))
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        // kadai2-4
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        receiver = registerReceiver(intentFilter) {

        }
        }
}
