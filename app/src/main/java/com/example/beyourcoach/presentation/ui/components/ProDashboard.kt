package com.example.beyourcoach.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProDashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "PRO DASHBOARD", fontSize = 28.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "1RM PROGRESS", color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(100.dp)) // Placeholder for Chart
                Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(Color.Gray))
                Text(text = "Detailed 1RM analytics enabled", fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "VOLUME ANALYTICS", color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(100.dp)) // Placeholder for Chart
                Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(Color.Gray))
                Text(text = "Weekly volume: 15,400 kg", fontSize = 12.sp)
            }
        }
    }
}
