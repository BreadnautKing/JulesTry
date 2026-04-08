package com.example.beyourcoach.domain.model

enum class ProductCategory {
    PROTEIN, CARBS, FAT_FIBER
}

data class Product(
    val id: Long? = null,
    val name: String,
    val kCal: Double,
    val protein: Double,
    val pricePerUnit: Double,
    val category: ProductCategory
)
