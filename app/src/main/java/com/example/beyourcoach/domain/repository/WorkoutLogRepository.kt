package com.example.beyourcoach.domain.repository

import com.example.beyourcoach.domain.model.WorkoutLog
import kotlinx.coroutines.flow.Flow

interface WorkoutLogRepository {
    fun getAllWorkoutLogs(): Flow<List<WorkoutLog>>
    suspend fun insertWorkoutLog(workoutLog: WorkoutLog)
    suspend fun deleteWorkoutLog(workoutLog: WorkoutLog)
}
