package com.example.composeapp.ui.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composeapp.model.Sample2Model
import com.example.composeapp.model.SampleModel

@Composable
fun SamplePage(sample: SampleModel, sample2: Sample2Model) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Text(text = sample.toString())
        }
        item {
            Text(text = sample2.toString())
        }
    }
}