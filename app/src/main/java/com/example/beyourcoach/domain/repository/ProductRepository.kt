package com.example.beyourcoach.domain.repository

import com.example.beyourcoach.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts(): Flow<List<Product>>
    suspend fun insertProduct(product: Product)
    suspend fun deleteProduct(product: Product)
}
