package com.example.beyourcoach.di

import android.app.Application
import androidx.room.Room
import com.example.beyourcoach.data.local.AppDatabase
import com.example.beyourcoach.data.local.dao.ExerciseDao
import com.example.beyourcoach.data.local.dao.ProductDao
import com.example.beyourcoach.data.local.dao.UserDao
import com.example.beyourcoach.data.local.dao.WorkoutLogDao
import com.example.beyourcoach.data.repository.ProductRepositoryImpl
import com.example.beyourcoach.data.repository.UserRepositoryImpl
import com.example.beyourcoach.domain.repository.ProductRepository
import com.example.beyourcoach.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao

    @Provides
    @Singleton
    fun provideExerciseDao(db: AppDatabase): ExerciseDao = db.exerciseDao

    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase): ProductDao = db.productDao

    @Provides
    @Singleton
    fun provideWorkoutLogDao(db: AppDatabase): WorkoutLogDao = db.workoutLogDao

    @Provides
    @Singleton
    fun provideUserRepository(dao: UserDao): UserRepository {
        return UserRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideProductRepository(dao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(dao)
    }
}
