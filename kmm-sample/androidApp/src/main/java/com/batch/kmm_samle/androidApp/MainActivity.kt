package com.batch.kmm_samle.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.batch.kmm_samle.shared.Greeting
import android.widget.TextView

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        val tvCount: TextView = findViewById(R.id.text_view_count)
        val btCountApp: Button = findViewById(R.id.button_count_app)
        tv.text = greet()
        btCountApp.setOnClickListener {
        }
    }
}