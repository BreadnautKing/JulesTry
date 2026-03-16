package com.example.beyourcoach.domain.model

data class Product(
    val id: Long?,
    val name: String,
    val kCal: Double,
    val protein: Double,
    val pricePerUnit: Double
)
