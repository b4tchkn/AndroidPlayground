package com.batch.compose_navigation_sample

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposenavigationsampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = "This is MainActivity")
                        NextButton(onClickButton = ::goToSecondActivity)
                    }
                }
            }
        }
    }

    private fun goToSecondActivity() {
        startActivity(
            SecondActivity.createIntent(
                this,
                Sample(id = 1, content = "This is content.")
            )
        )
    }
}

@Composable
fun NextButton(onClickButton: () -> Unit) {
    Button(onClick = onClickButton) {
        Text(text = "Next")
    }
}