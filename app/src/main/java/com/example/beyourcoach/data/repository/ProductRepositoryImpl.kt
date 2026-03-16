package com.example.beyourcoach.data.repository

import com.example.beyourcoach.data.local.dao.ProductDao
import com.example.beyourcoach.domain.model.Product
import com.example.beyourcoach.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.beyourcoach.data.local.entities.ProductEntity

class ProductRepositoryImpl(
    private val dao: ProductDao
) : ProductRepository {
    override fun getAllProducts(): Flow<List<Product>> {
        return dao.getAllProducts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertProduct(product: Product) {
        dao.insertProduct(product.toEntity())
    }

    override suspend fun deleteProduct(product: Product) {
        dao.deleteProduct(product.toEntity())
    }
}

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        name = name,
        kCal = kCal,
        protein = protein,
        pricePerUnit = pricePerUnit,
        category = category
    )
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id ?: 0,
        name = name,
        kCal = kCal,
        protein = protein,
        pricePerUnit = pricePerUnit,
        category = category
    )
}
