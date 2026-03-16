package com.example.beyourcoach.data.repository

import com.example.beyourcoach.data.local.dao.WorkoutLogDao
import com.example.beyourcoach.data.local.entities.WorkoutLogEntity
import com.example.beyourcoach.domain.model.WorkoutLog
import com.example.beyourcoach.domain.repository.WorkoutLogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WorkoutLogRepositoryImpl(
    private val dao: WorkoutLogDao
) : WorkoutLogRepository {
    override fun getAllWorkoutLogs(): Flow<List<WorkoutLog>> {
        return dao.getAllWorkoutLogs().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertWorkoutLog(workoutLog: WorkoutLog) {
        dao.insertWorkoutLog(workoutLog.toEntity())
    }

    override suspend fun deleteWorkoutLog(workoutLog: WorkoutLog) {
        dao.deleteWorkoutLog(workoutLog.toEntity())
    }
}

fun WorkoutLogEntity.toDomain(): WorkoutLog {
    return WorkoutLog(
        id = id,
        exerciseId = exerciseId,
        sets = sets,
        reps = reps,
        weight = weight,
        rpe = rpe
    )
}

fun WorkoutLog.toEntity(): WorkoutLogEntity {
    return WorkoutLogEntity(
        id = id ?: 0,
        exerciseId = exerciseId,
        sets = sets,
        reps = reps,
        weight = weight,
        rpe = rpe
    )
}
