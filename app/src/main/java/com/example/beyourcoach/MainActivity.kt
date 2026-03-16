package com.example.beyourcoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.beyourcoach.presentation.screen.MainScreen
import com.example.beyourcoach.presentation.viewmodel.BudgetViewModel
import com.example.beyourcoach.presentation.viewmodel.ThemeViewModel
import com.example.beyourcoach.presentation.viewmodel.WorkoutTrackingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeViewModel: ThemeViewModel = hiltViewModel()
            val workoutViewModel: WorkoutTrackingViewModel = hiltViewModel()
            val budgetViewModel: BudgetViewModel = hiltViewModel()

            MainScreen(
                themeViewModel = themeViewModel,
                workoutViewModel = workoutViewModel,
                budgetViewModel = budgetViewModel
            )
        }
    }
}
