package com.example.beyourcoach.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.beyourcoach.domain.util.formatCurrency
import com.example.beyourcoach.presentation.viewmodel.BudgetViewModel

@Composable
fun BudgetPlannerScreen(viewModel: BudgetViewModel) {
    var budgetInput by remember { mutableStateOf("5000") }
    var calorieInput by remember { mutableStateOf("2000") }
    val shoppingList by viewModel.shoppingList.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = budgetInput,
            onValueChange = { budgetInput = it },
            label = { Text("Weekly Budget") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = calorieInput,
            onValueChange = { calorieInput = it },
            label = { Text("Daily Calories") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.calculateList(
                    budgetInput.toDoubleOrNull() ?: 0.0,
                    calorieInput.toDoubleOrNull() ?: 2000.0
                )
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Calculate Shopping List")
        }

        LazyColumn {
            items(shoppingList) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "${item.product.name} (x${String.format("%.2f", item.quantity)})")
                    Text(text = item.totalPrice.formatCurrency())
                }
            }
        }
    }
}
