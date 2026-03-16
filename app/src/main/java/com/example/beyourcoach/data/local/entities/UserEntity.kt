package com.example.beyourcoach.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class UserMode {
    LITE, PRO
}

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val goals: String,
    val budget: Double,
    val mode: UserMode
)
