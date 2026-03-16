package com.example.beyourcoach.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.beyourcoach.presentation.viewmodel.UserViewModel

@Composable
fun UserProfileScreen(viewModel: UserViewModel) {
    val user by viewModel.user.collectAsState()

    Column {
        Text(text = "User Profile")
        user?.let {
            Text(text = "Goals: ${it.goals}")
            Text(text = "Budget: ${it.budget}")
            Text(text = "Mode: ${it.mode}")
        } ?: Text(text = "No user found")
    }
}
