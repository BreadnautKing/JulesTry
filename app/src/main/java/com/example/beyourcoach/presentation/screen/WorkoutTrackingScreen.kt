package com.example.beyourcoach.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.beyourcoach.domain.model.UserMode
import com.example.beyourcoach.presentation.ui.components.LiteWorkoutContent
import com.example.beyourcoach.presentation.ui.components.ProWorkoutContent
import com.example.beyourcoach.presentation.viewmodel.ThemeViewModel
import com.example.beyourcoach.presentation.viewmodel.WorkoutTrackingViewModel

@Composable
fun WorkoutTrackingScreen(
    themeViewModel: ThemeViewModel,
    workoutViewModel: WorkoutTrackingViewModel
) {
    val mode by themeViewModel.mode.collectAsState()
    val exercises by workoutViewModel.exercises.collectAsState()
    val inputs by workoutViewModel.workoutInputs.collectAsState()

    Box {
        when (mode) {
            UserMode.LITE -> LiteWorkoutContent(exercises = exercises)
            UserMode.PRO -> ProWorkoutContent(
                exercises = exercises,
                inputs = inputs,
                onInputChange = { id, weight, reps, rpe ->
                    workoutViewModel.onInputChange(id, weight, reps, rpe)
                },
                onSaveSet = { workoutViewModel.saveSet(it) }
            )
        }
    }
}
