package com.example.beyourcoach.data.local

import com.example.beyourcoach.data.local.entities.ExerciseEntity
import com.example.beyourcoach.data.local.entities.ProductEntity
import com.example.beyourcoach.domain.model.ProductCategory
import javax.inject.Inject
import javax.inject.Provider

class DatabaseInitializer @Inject constructor(
    private val dbProvider: Provider<AppDatabase>
) {
    suspend fun initialize() {
        val db = dbProvider.get()
        val exerciseCount = db.exerciseDao.getAllExercisesCount()

        if (exerciseCount == 0) {
            prepopulateExercises(db)
            prepopulateProducts(db)
        }
    }

    private suspend fun prepopulateExercises(db: AppDatabase) {
        val exercises = listOf(
            // LITE Exercises (7)
            ExerciseEntity(name = "Push-ups", muscleGroup = "Chest", videoUrl = "", isPro = false),
            ExerciseEntity(name = "Bodyweight Squats", muscleGroup = "Legs", videoUrl = "", isPro = false),
            ExerciseEntity(name = "Plank", muscleGroup = "Core", videoUrl = "", isPro = false),
            ExerciseEntity(name = "Lunges", muscleGroup = "Legs", videoUrl = "", isPro = false),
            ExerciseEntity(name = "Jumping Jacks", muscleGroup = "Full Body", videoUrl = "", isPro = false),
            ExerciseEntity(name = "Burpees", muscleGroup = "Full Body", videoUrl = "", isPro = false),
            ExerciseEntity(name = "Mountain Climbers", muscleGroup = "Core", videoUrl = "", isPro = false),

            // PRO Exercises (8)
            ExerciseEntity(name = "Bench Press", muscleGroup = "Chest", videoUrl = "", isPro = true),
            ExerciseEntity(name = "Deadlift", muscleGroup = "Back/Legs", videoUrl = "", isPro = true),
            ExerciseEntity(name = "Barbell Back Squat", muscleGroup = "Legs", videoUrl = "", isPro = true),
            ExerciseEntity(name = "Overhead Press", muscleGroup = "Shoulders", videoUrl = "", isPro = true),
            ExerciseEntity(name = "Pull-ups", muscleGroup = "Back", videoUrl = "", isPro = true),
            ExerciseEntity(name = "Barbell Row", muscleGroup = "Back", videoUrl = "", isPro = true),
            ExerciseEntity(name = "Dips", muscleGroup = "Triceps/Chest", videoUrl = "", isPro = true),
            ExerciseEntity(name = "Romanian Deadlift", muscleGroup = "Hamstrings", videoUrl = "", isPro = true)
        )
        exercises.forEach { db.exerciseDao.insertExercise(it) }
    }

    private suspend fun prepopulateProducts(db: AppDatabase) {
        val products = listOf(
            ProductEntity(name = "Chicken Breast", kCal = 165.0, protein = 31.0, pricePerUnit = 400.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Eggs (10 pcs)", kCal = 155.0, protein = 13.0, pricePerUnit = 120.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Buckwheat", kCal = 340.0, protein = 12.0, pricePerUnit = 90.0, category = ProductCategory.CARBS),
            ProductEntity(name = "Whey Protein", kCal = 390.0, protein = 80.0, pricePerUnit = 3500.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Cottage Cheese", kCal = 98.0, protein = 18.0, pricePerUnit = 300.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Turkey Fillet", kCal = 189.0, protein = 29.0, pricePerUnit = 550.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Salmon", kCal = 208.0, protein = 20.0, pricePerUnit = 1500.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Rice", kCal = 130.0, protein = 2.7, pricePerUnit = 100.0, category = ProductCategory.CARBS),
            ProductEntity(name = "Pasta", kCal = 158.0, protein = 5.8, pricePerUnit = 110.0, category = ProductCategory.CARBS),
            ProductEntity(name = "Oatmeal", kCal = 389.0, protein = 16.9, pricePerUnit = 80.0, category = ProductCategory.CARBS),
            ProductEntity(name = "Potato", kCal = 77.0, protein = 2.0, pricePerUnit = 50.0, category = ProductCategory.CARBS),
            ProductEntity(name = "Milk", kCal = 42.0, protein = 3.4, pricePerUnit = 90.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Greek Yogurt", kCal = 59.0, protein = 10.0, pricePerUnit = 250.0, category = ProductCategory.PROTEIN),
            ProductEntity(name = "Peanut Butter", kCal = 588.0, protein = 25.0, pricePerUnit = 400.0, category = ProductCategory.FAT_FIBER),
            ProductEntity(name = "Olive Oil", kCal = 884.0, protein = 0.0, pricePerUnit = 800.0, category = ProductCategory.FAT_FIBER),
            ProductEntity(name = "Avocado", kCal = 160.0, protein = 2.0, pricePerUnit = 600.0, category = ProductCategory.FAT_FIBER),
            ProductEntity(name = "Broccoli", kCal = 34.0, protein = 2.8, pricePerUnit = 300.0, category = ProductCategory.FAT_FIBER),
            ProductEntity(name = "Spinach", kCal = 23.0, protein = 2.9, pricePerUnit = 400.0, category = ProductCategory.FAT_FIBER),
            ProductEntity(name = "Apples", kCal = 52.0, protein = 0.3, pricePerUnit = 130.0, category = ProductCategory.FAT_FIBER),
            ProductEntity(name = "Bananas", kCal = 89.0, protein = 1.1, pricePerUnit = 140.0, category = ProductCategory.CARBS)
        )
        products.forEach { db.productDao.insertProduct(it) }
    }
}
