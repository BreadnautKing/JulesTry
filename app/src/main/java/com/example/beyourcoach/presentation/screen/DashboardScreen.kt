package com.example.beyourcoach.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.beyourcoach.domain.model.UserMode
import com.example.beyourcoach.presentation.ui.components.LiteDashboard
import com.example.beyourcoach.presentation.ui.components.ProDashboard
import com.example.beyourcoach.presentation.viewmodel.ThemeViewModel

@Composable
fun DashboardScreen(themeViewModel: ThemeViewModel) {
    val mode by themeViewModel.mode.collectAsState()

    when (mode) {
        UserMode.LITE -> LiteDashboard()
        UserMode.PRO -> ProDashboard()
    }
}
