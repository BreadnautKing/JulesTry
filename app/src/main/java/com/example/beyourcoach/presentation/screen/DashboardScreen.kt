package com.example.beyourcoach.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.beyourcoach.domain.model.UserMode
import com.example.beyourcoach.presentation.ui.components.LiteDashboard
import com.example.beyourcoach.presentation.ui.components.MainTopBar
import com.example.beyourcoach.presentation.ui.components.ProDashboard
import com.example.beyourcoach.presentation.ui.theme.BeYourCoachTheme
import com.example.beyourcoach.presentation.viewmodel.ThemeViewModel

@Composable
fun DashboardScreen(themeViewModel: ThemeViewModel) {
    val mode by themeViewModel.mode.collectAsState()

    BeYourCoachTheme(mode = mode) {
        Scaffold(
            topBar = {
                MainTopBar(
                    currentMode = mode,
                    onToggleMode = { themeViewModel.toggleMode() }
                )
            }
        ) { paddingValues ->
            androidx.compose.foundation.layout.Box(modifier = Modifier.padding(paddingValues)) {
                when (mode) {
                    UserMode.LITE -> LiteDashboard()
                    UserMode.PRO -> ProDashboard()
                }
            }
        }
    }
}
