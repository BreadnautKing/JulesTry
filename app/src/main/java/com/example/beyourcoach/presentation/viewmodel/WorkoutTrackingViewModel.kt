package com.example.beyourcoach.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beyourcoach.domain.model.Exercise
import com.example.beyourcoach.domain.model.WorkoutLog
import com.example.beyourcoach.domain.repository.ExerciseRepository
import com.example.beyourcoach.domain.repository.WorkoutLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutTrackingViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository,
    private val workoutLogRepository: WorkoutLogRepository
) : ViewModel() {

    private val _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> = _exercises.asStateFlow()

    private val _restTimeRemaining = MutableStateFlow(0)
    val restTimeRemaining: StateFlow<Int> = _restTimeRemaining.asStateFlow()

    private var timerJob: Job? = null

    init {
        loadExercises()
    }

    private fun loadExercises() {
        viewModelScope.launch {
            exerciseRepository.getAllExercises().collect {
                _exercises.value = it
            }
        }
    }

    fun saveSet(workoutLog: WorkoutLog) {
        viewModelScope.launch {
            workoutLogRepository.insertWorkoutLog(workoutLog)
            startRestTimer(60) // 60 seconds rest
        }
    }

    private fun startRestTimer(seconds: Int) {
        timerJob?.cancel()
        _restTimeRemaining.value = seconds
        timerJob = viewModelScope.launch {
            while (_restTimeRemaining.value > 0) {
                delay(1000)
                _restTimeRemaining.value -= 1
            }
        }
    }
}
