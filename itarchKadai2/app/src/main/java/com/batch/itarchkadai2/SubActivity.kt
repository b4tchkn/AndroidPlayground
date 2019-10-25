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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        // kadai2-2
        intentButton.setOnClickListener {
            // ボタン押されたときにEditTextに入っているURIを使って暗黙的インテントでstartActivityする
            val intent =
                Intent("android.intent.action.VIEW", Uri.parse(urlEditText.text.toString()))
            startActivity(intent)
        }

        // kadai2-4
        // MyReceiverからBATTERY_CHANGEDアクションのブロードキャスト・インテントを受け取る
        val receiver = MyReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED")
        registerReceiver(receiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        // kadai2-3
        // MainActivityから受け取ったインテントに入っているテキストを取得してToastで表示
        val intentText = intent.getStringExtra("gotoSubActivity")
        Toast.makeText(this, intentText, Toast.LENGTH_LONG).show()
    }
}
