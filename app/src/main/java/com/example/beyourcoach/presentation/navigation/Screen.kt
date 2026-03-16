package com.example.beyourcoach.presentation.navigation

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object BudgetPlanner : Screen("budget_planner")
    object WorkoutLog : Screen("workout_log")
}
