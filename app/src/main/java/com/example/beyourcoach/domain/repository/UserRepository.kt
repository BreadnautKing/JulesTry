package com.example.beyourcoach.domain.repository

import com.example.beyourcoach.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(): Flow<User?>
    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User)
}
