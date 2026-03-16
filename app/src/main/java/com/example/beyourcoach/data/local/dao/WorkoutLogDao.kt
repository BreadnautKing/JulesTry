package com.example.beyourcoach.data.local.dao

import androidx.room.*
import com.example.beyourcoach.data.local.entities.WorkoutLogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutLogDao {
    @Query("SELECT * FROM workout_logs")
    fun getAllWorkoutLogs(): Flow<List<WorkoutLogEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutLog(workoutLog: WorkoutLogEntity)

    @Delete
    suspend fun deleteWorkoutLog(workoutLog: WorkoutLogEntity)
}
