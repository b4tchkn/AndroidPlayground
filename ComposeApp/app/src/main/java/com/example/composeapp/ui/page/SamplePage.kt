package com.example.composeapp.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.composeapp.model.Sample2Model
import com.example.composeapp.model.SampleModel

@Composable
fun SamplePage(sample: SampleModel, sample2: Sample2Model) {
    Column {
        Text(text = sample.toString())
        Text(text = sample2.toString())
    }
}