package com.example.beyourcoach.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.beyourcoach.R

data class NavItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavItem(stringResource(id = R.string.app_name), Icons.Default.Home, Screen.Dashboard),
        NavItem(stringResource(id = R.string.budget), Icons.Default.ShoppingCart, Screen.BudgetPlanner),
        NavItem(stringResource(id = R.string.workout), Icons.Default.List, Screen.WorkoutLog)
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
