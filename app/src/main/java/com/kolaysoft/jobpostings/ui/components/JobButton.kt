package com.kolaysoft.jobpostings.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun JobButton(modifier: Modifier, buttonText: String, onClick: () -> Unit) {
    Button(modifier = modifier.width(300.dp), onClick = {
        onClick.invoke()
    }) {
        Text(text = buttonText)
    }
}