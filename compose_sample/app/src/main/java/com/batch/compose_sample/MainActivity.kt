package com.batch.compose_sample

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.batch.compose_sample.ui.theme.Compose_sampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_sampleTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "compose_sample")
                            }
                        )
                    },
                    bodyContent = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            GreetingTextView(name = "Bob")
                            Spacer(modifier = Modifier.preferredHeight(16.dp))
                            TestButton(activity = this@MainActivity)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun GreetingTextView(name: String) {
    Text(text = "Hello, $name")
}

@Composable
fun TestButton(activity: MainActivity) {
    Button(
        onClick = {
            val intent = Intent(activity, DetailActivity::class.java)
            startActivity(
                activity,
                intent,
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        }
    ) {
        Text(text = "Button")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_sampleTheme {
        GreetingTextView("Android")
    }
}
