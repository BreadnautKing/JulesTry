package com.example.beyourcoach.domain.model

data class Exercise(
    val id: Long? = null,
    val name: String,
    val muscleGroup: String,
    val videoUrl: String,
    val isPro: Boolean
)
