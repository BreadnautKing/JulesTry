package com.example.beyourcoach.domain.model

enum class UserMode {
    LITE, PRO
}

data class User(
    val id: Long?,
    val goals: String,
    val budget: Double,
    val mode: UserMode
)
