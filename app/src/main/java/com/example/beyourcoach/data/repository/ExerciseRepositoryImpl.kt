package com.example.beyourcoach.data.repository

import com.example.beyourcoach.data.local.dao.ExerciseDao
import com.example.beyourcoach.data.local.entities.ExerciseEntity
import com.example.beyourcoach.domain.model.Exercise
import com.example.beyourcoach.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExerciseRepositoryImpl(
    private val dao: ExerciseDao
) : ExerciseRepository {
    override fun getAllExercises(): Flow<List<Exercise>> {
        return dao.getAllExercises().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertExercise(exercise: Exercise) {
        dao.insertExercise(exercise.toEntity())
    }

    override suspend fun deleteExercise(exercise: Exercise) {
        dao.deleteExercise(exercise.toEntity())
    }
}

fun ExerciseEntity.toDomain(): Exercise {
    return Exercise(
        id = id,
        name = name,
        muscleGroup = muscleGroup,
        videoUrl = videoUrl
    )
}

fun Exercise.toEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = id ?: 0,
        name = name,
        muscleGroup = muscleGroup,
        videoUrl = videoUrl
    )
}
