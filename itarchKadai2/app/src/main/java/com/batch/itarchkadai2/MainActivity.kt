package com.batch.itarchkadai2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityButton.setOnClickListener {
            // kadai 2-3
            val uri = Uri.parse("batch://subactivity-intent")
            val intent = Intent("android.intent.action.VIEW", uri)
            intent.putExtra("gotoSubActivity", "AAAAAAAA")
            startActivity(intent)

            // kadai2-1
//            val intent = Intent(this, SubActivity::class.java)
//            startActivity(intent)
        }
    }
}
