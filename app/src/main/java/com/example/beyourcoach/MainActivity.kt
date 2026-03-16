package com.example.beyourcoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.beyourcoach.data.local.DatabaseInitializer
import com.example.beyourcoach.presentation.screen.MainScreen
import com.example.beyourcoach.presentation.viewmodel.BudgetViewModel
import com.example.beyourcoach.presentation.viewmodel.ThemeViewModel
import com.example.beyourcoach.presentation.viewmodel.WorkoutTrackingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var databaseInitializer: DatabaseInitializer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            databaseInitializer.initialize()
        }

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
