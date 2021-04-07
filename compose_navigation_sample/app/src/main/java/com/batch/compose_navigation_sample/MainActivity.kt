package com.batch.compose_navigation_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewTreeLifecycleOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewTreeLifecycleOwner.set(window.decorView, this)

        if (savedInstanceState == null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, MainFragment())
            fragmentTransaction.commit()
        }
    }
}