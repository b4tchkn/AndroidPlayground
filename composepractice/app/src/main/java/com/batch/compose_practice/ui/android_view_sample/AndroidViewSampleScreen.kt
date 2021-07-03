package com.batch.compose_practice.ui.android_view_sample

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.batch.compose_practice.R

@Composable
fun AndroidViewSampleScreen(navController: NavController) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.android_view_sample_title)
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back),
                            contentDescription = null,
                        )
                    }
                },
                title = {
                    Text(text = title)
                }
            )
        }
    ) {
        val context = LocalContext.current

        val customTextView = remember {
            TextView(context).apply {
                text = "これはrememberで定義した変数をAndroidViewに注入したTextViewです"
                setTextAppearance(R.style.Teal200_H1_Bold)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "これはComposableTextです", color = Color.Green)
            AndroidView(
                factory = { context ->
                    TextView(context).apply {
                        text = "これはAndroidViewで直接WrapしたTextViewです"
                        setTextAppearance(R.style.Purple200_H1_Bold)
                    }
                },
            )

            AndroidView({ customTextView })
        }
    }
}