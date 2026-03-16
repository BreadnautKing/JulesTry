package com.example.beyourcoach.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beyourcoach.domain.model.ShoppingItem
import com.example.beyourcoach.domain.use_case.CalculateShoppingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val calculateShoppingListUseCase: CalculateShoppingListUseCase
) : ViewModel() {

    private val _shoppingList = MutableStateFlow<List<ShoppingItem>>(emptyList())
    val shoppingList: StateFlow<List<ShoppingItem>> = _shoppingList.asStateFlow()

    fun calculateList(budget: Double, calories: Double) {
        viewModelScope.launch {
            _shoppingList.value = calculateShoppingListUseCase(budget, calories)
        }
    }
}
