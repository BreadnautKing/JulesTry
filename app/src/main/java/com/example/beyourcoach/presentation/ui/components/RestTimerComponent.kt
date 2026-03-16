package com.example.beyourcoach.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RestTimerComponent(timeRemaining: Int) {
    if (timeRemaining > 0) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.8f))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "REST: ${timeRemaining}s",
                color = Color.Yellow,
                fontSize = 18.sp
            )
        }
    }
}
