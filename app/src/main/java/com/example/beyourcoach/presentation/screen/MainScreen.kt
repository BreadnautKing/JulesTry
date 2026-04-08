package com.example.beyourcoach.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.beyourcoach.domain.model.UserMode
import com.example.beyourcoach.presentation.navigation.BottomNavigationBar
import com.example.beyourcoach.presentation.navigation.Screen
import com.example.beyourcoach.presentation.ui.components.MainTopBar
import com.example.beyourcoach.presentation.ui.theme.BeYourCoachTheme
import com.example.beyourcoach.presentation.viewmodel.BudgetViewModel
import com.example.beyourcoach.presentation.viewmodel.ThemeViewModel
import com.example.beyourcoach.presentation.viewmodel.WorkoutTrackingViewModel

@Composable
fun MainScreen(
    themeViewModel: ThemeViewModel,
    workoutViewModel: WorkoutTrackingViewModel,
    budgetViewModel: BudgetViewModel
) {
    val mode by themeViewModel.mode.collectAsState()
    val navController = rememberNavController()

    BeYourCoachTheme(mode = mode) {
        Scaffold(
            topBar = {
                MainTopBar(
                    currentMode = mode,
                    onToggleMode = { themeViewModel.toggleMode() }
                )
            },
            bottomBar = {
                BottomNavigationBar(navController = navController)
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Screen.Dashboard.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Screen.Dashboard.route) {
                    DashboardScreen(themeViewModel)
                }
                composable(Screen.BudgetPlanner.route) {
                    BudgetPlannerScreen(budgetViewModel)
                }
                composable(Screen.WorkoutLog.route) {
                    WorkoutTrackingScreen(themeViewModel, workoutViewModel)
                }
            }
        }
    }
}
