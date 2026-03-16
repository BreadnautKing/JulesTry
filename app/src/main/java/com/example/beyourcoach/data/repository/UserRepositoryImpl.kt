package com.example.beyourcoach.data.repository

import com.example.beyourcoach.data.local.dao.UserDao
import com.example.beyourcoach.data.mapper.toDomain
import com.example.beyourcoach.data.mapper.toEntity
import com.example.beyourcoach.domain.model.User
import com.example.beyourcoach.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val dao: UserDao
) : UserRepository {
    override fun getUser(): Flow<User?> {
        return dao.getUser().map { it?.toDomain() }
    }

    override suspend fun insertUser(user: User) {
        dao.insertUser(user.toEntity())
    }

    override suspend fun deleteUser(user: User) {
        dao.deleteUser(user.toEntity())
    }
}
