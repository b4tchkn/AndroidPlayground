package com.batch.compose_practice.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainPracticeSectionItem(
    sectionTitle: String,
    navigateTo: () -> Unit,
) {
    Column(
        content = {
            Text(
                modifier = Modifier
                    .clickable(onClick = navigateTo)
                    .fillMaxWidth()
                    .padding(8.dp),
                text = sectionTitle,
                style = MaterialTheme.typography.h6,
            )
            Divider()
        },
    )
}