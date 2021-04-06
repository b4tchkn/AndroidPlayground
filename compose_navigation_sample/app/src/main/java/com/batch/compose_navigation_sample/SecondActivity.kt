package com.batch.compose_navigation_sample

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.batch.compose_navigation_sample.ui.theme.ComposenavigationsampleTheme

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposenavigationsampleTheme {
                Surface(color = Color.Blue) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = "This is SecondActivity")
                        Text(text = getExtras().toString())
                        BackButton(onClickButton = { finish() })
                    }
                }
            }
        }
    }

    private fun getExtras(): Sample = intent.getSerializableExtra("sample_key") as Sample

    companion object {
        fun createIntent(activity: AppCompatActivity, sample: Sample): Intent {
            return Intent(activity, SecondActivity::class.java).apply {
                putExtra("sample_key", sample)
            }
        }
    }
}

@Composable
fun BackButton(onClickButton: () -> Unit) {
    Button(onClick = onClickButton) {
        Text(text = "Back")
    }
}