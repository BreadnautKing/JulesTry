package com.example.beyourcoach.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.beyourcoach.domain.model.ProductCategory

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val kCal: Double,
    val protein: Double,
    val pricePerUnit: Double,
    val category: ProductCategory
)
