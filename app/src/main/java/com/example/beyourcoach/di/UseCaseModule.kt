package com.example.beyourcoach.di

import com.example.beyourcoach.domain.repository.ProductRepository
import com.example.beyourcoach.domain.use_case.CalculateShoppingListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCalculateShoppingListUseCase(
        productRepository: ProductRepository
    ): CalculateShoppingListUseCase {
        return CalculateShoppingListUseCase(productRepository)
    }
}
