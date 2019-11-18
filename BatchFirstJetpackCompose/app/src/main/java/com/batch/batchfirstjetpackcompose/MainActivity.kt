package com.batch.batchfirstjetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        Text(text = "Hello World")
        Text(text = "hogehogehoge")
        Text(text = "hagehagehage")
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    MaterialTheme {
        Greeting()
    }
}
