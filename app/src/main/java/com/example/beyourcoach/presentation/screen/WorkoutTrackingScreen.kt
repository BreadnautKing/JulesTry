package com.example.beyourcoach.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.beyourcoach.domain.model.UserMode
import com.example.beyourcoach.presentation.ui.components.*
import com.example.beyourcoach.presentation.ui.theme.BeYourCoachTheme
import com.example.beyourcoach.presentation.viewmodel.ThemeViewModel
import com.example.beyourcoach.presentation.viewmodel.WorkoutTrackingViewModel

@Composable
fun WorkoutTrackingScreen(
    themeViewModel: ThemeViewModel,
    workoutViewModel: WorkoutTrackingViewModel
) {
    val mode by themeViewModel.mode.collectAsState()
    val exercises by workoutViewModel.exercises.collectAsState()
    val restTime by workoutViewModel.restTimeRemaining.collectAsState()

    BeYourCoachTheme(mode = mode) {
        Scaffold(
            topBar = {
                MainTopBar(
                    currentMode = mode,
                    onToggleMode = { themeViewModel.toggleMode() }
                )
            },
            bottomBar = {
                RestTimerComponent(timeRemaining = restTime)
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when (mode) {
                    UserMode.LITE -> LiteWorkoutContent(exercises = exercises)
                    UserMode.PRO -> ProWorkoutContent(
                        exercises = exercises,
                        onSaveSet = { workoutViewModel.saveSet(it) }
                    )
                }
            }
        }
    }
}
