package com.example.beyourcoach.domain.use_case

import com.example.beyourcoach.domain.model.Product
import com.example.beyourcoach.domain.model.ProductCategory
import com.example.beyourcoach.domain.model.ShoppingItem
import com.example.beyourcoach.domain.repository.ProductRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CalculateShoppingListUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(weeklyBudget: Double, dailyCalories: Double): List<ShoppingItem> {
        val allProducts = productRepository.getAllProducts().first()

        // If DB is empty, use defaults for CIS/Russia as requested
        val products = if (allProducts.isEmpty()) {
            getDefaultProducts()
        } else {
            allProducts
        }

        val proteinBudget = weeklyBudget * 0.60
        val carbBudget = weeklyBudget * 0.30
        val fatFiberBudget = weeklyBudget * 0.10

        val shoppingList = mutableListOf<ShoppingItem>()

        // 1. Prioritize Protein (based on price/protein ratio)
        val proteins = products.filter { it.category == ProductCategory.PROTEIN }
            .sortedBy { it.pricePerUnit / it.protein }

        shoppingList.addAll(allocateBudget(proteins, proteinBudget))

        // 2. Allocate Carbs
        val carbs = products.filter { it.category == ProductCategory.CARBS }
            .sortedBy { it.pricePerUnit / it.kCal }

        shoppingList.addAll(allocateBudget(carbs, carbBudget))

        // 3. Allocate Fat/Fiber
        val fats = products.filter { it.category == ProductCategory.FAT_FIBER }
            .sortedBy { it.pricePerUnit / it.kCal }

        shoppingList.addAll(allocateBudget(fats, fatFiberBudget))

        return shoppingList
    }

    private fun allocateBudget(products: List<Product>, budget: Double): List<ShoppingItem> {
        if (products.isEmpty()) return emptyList()

        val items = mutableListOf<ShoppingItem>()
        var remainingBudget = budget

        // Simple allocation: try to buy the most efficient one first
        // In a real app, this would be more complex to ensure variety
        for (product in products) {
            if (remainingBudget <= 0) break

            // Buy as much as possible of the most efficient product,
            // but let's say we limit to some reasonable amount or divide between top 2
            val amountToSpend = remainingBudget / (products.size.coerceAtMost(2))
            val quantity = amountToSpend / product.pricePerUnit

            if (quantity > 0) {
                items.add(ShoppingItem(product, quantity, amountToSpend))
                remainingBudget -= amountToSpend
            }
        }

        return items
    }

    private fun getDefaultProducts(): List<Product> {
        return listOf(
            Product(name = "Eggs", kCal = 155.0, protein = 13.0, pricePerUnit = 12.0, category = ProductCategory.PROTEIN), // 120 RUB per 10
            Product(name = "Chicken", kCal = 165.0, protein = 31.0, pricePerUnit = 350.0, category = ProductCategory.PROTEIN),
            Product(name = "Curd", kCal = 100.0, protein = 18.0, pricePerUnit = 300.0, category = ProductCategory.PROTEIN),
            Product(name = "Buckwheat", kCal = 340.0, protein = 12.0, pricePerUnit = 100.0, category = ProductCategory.CARBS),
            Product(name = "Rice", kCal = 130.0, protein = 2.7, pricePerUnit = 90.0, category = ProductCategory.CARBS),
            Product(name = "Apple", kCal = 52.0, protein = 0.3, pricePerUnit = 120.0, category = ProductCategory.FAT_FIBER)
        )
    }
}
