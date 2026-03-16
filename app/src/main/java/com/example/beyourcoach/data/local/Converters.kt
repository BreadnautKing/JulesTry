package com.example.beyourcoach.data.local

import androidx.room.TypeConverter
import com.example.beyourcoach.data.local.entities.UserMode

class Converters {
    @TypeConverter
    fun fromUserMode(value: UserMode): String {
        return value.name
    }

    @TypeConverter
    fun toUserMode(value: String): UserMode {
        return UserMode.valueOf(value)
    }
}
