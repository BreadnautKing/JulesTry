package com.example.beyourcoach.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.beyourcoach.data.local.dao.ExerciseDao
import com.example.beyourcoach.data.local.dao.ProductDao
import com.example.beyourcoach.data.local.dao.UserDao
import com.example.beyourcoach.data.local.dao.WorkoutLogDao
import com.example.beyourcoach.data.local.entities.ExerciseEntity
import com.example.beyourcoach.data.local.entities.ProductEntity
import com.example.beyourcoach.data.local.entities.UserEntity
import com.example.beyourcoach.data.local.entities.WorkoutLogEntity

@Database(
    entities = [
        UserEntity::class,
        ExerciseEntity::class,
        ProductEntity::class,
        WorkoutLogEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val exerciseDao: ExerciseDao
    abstract val productDao: ProductDao
    abstract val workoutLogDao: WorkoutLogDao

    companion object {
        const val DATABASE_NAME = "be_your_coach_db"
    }
}
