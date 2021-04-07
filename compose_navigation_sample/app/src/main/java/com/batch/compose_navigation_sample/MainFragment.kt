package com.batch.compose_navigation_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.batch.compose_navigation_sample.ui.theme.ComposenavigationsampleTheme

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ComposenavigationsampleTheme {
                    Surface(color = Color.Green) {
                        Text(text = "This is Compose on MainFragment")
                    }
                }
            }
        }
    }
}