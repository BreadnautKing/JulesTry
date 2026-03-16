package com.example.beyourcoach.data.mapper

import com.example.beyourcoach.data.local.entities.UserEntity
import com.example.beyourcoach.data.local.entities.UserMode as EntityUserMode
import com.example.beyourcoach.domain.model.User
import com.example.beyourcoach.domain.model.UserMode as DomainUserMode

fun UserEntity.toDomain(): User {
    return User(
        id = id,
        goals = goals,
        budget = budget,
        mode = DomainUserMode.valueOf(mode.name)
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id ?: 0,
        goals = goals,
        budget = budget,
        mode = EntityUserMode.valueOf(mode.name)
    )
}
