package com.batch.timer

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    private val handler = Handler()
    private var timeCount = 0
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val runnable = object : Runnable {
            override fun run() {
                timeCount++
                text_timer.text = timeToText(timeCount)
                // 1秒間隔でDelayを発生させてrunさせる
                handler.postDelayed(this, 1000)
            }
        }

        button_start.setOnClickListener {
            // タイマー動いていなかったらhandlerにpostしてRunnableの中のrunを回す
            if (!isRunning) {
                handler.post(runnable)
                isRunning = true
            }
        }

        button_stop.setOnClickListener {
            // タイマーが動いてたらhandlerからremoveしてタイマーを止める
            if (isRunning) {
                handler.removeCallbacks(runnable)
                isRunning = false
            }
        }
    }

    private fun timeToText(time: Int): String {
        return when (time) {
            0 -> {
                "00:00:00"
            }
            else -> {
                val hour = time / 3600
                val minute = time % 3600 / 60
                val second = time % 60
                "%1$02d:%2$02d:%3$02d".format(hour, minute, second)
            }
        }
    }
}