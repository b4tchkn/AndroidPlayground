package com.batch.compose_practice

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.batch.compose_practice.ui.theme.ComposepracticeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposepracticeTheme {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}