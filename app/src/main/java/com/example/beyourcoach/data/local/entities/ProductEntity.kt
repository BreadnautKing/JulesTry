package com.example.beyourcoach.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val kCal: Double,
    val protein: Double,
    val pricePerUnit: Double
)
