package com.batch.batchmlkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun textRecognition(view: View) {
        startActivity(Intent(this@MainActivity, TextRecognitionActivity::class.java))
    }

    fun faceDetection(view: View) {
    }

    fun barcodeScanner(view: View) {
    }

    fun imageLabeling(view: View) {
    }
}
