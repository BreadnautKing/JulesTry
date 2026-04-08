package com.example.beyourcoach.domain.model

data class WorkoutLog(
    val id: Long?,
    val exerciseId: Long,
    val sets: Int,
    val reps: Int,
    val weight: Double,
    val rpe: Int
)
