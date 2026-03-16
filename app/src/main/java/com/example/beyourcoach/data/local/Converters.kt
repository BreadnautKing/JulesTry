package com.example.beyourcoach.data.local

import androidx.room.TypeConverter
import com.example.beyourcoach.data.local.entities.UserMode
import com.example.beyourcoach.domain.model.ProductCategory

class Converters {
    @TypeConverter
    fun fromUserMode(value: UserMode): String {
        return value.name
    }

    @TypeConverter
    fun toUserMode(value: String): UserMode {
        return UserMode.valueOf(value)
    }

    @TypeConverter
    fun fromProductCategory(value: ProductCategory): String {
        return value.name
    }

    @TypeConverter
    fun toProductCategory(value: String): ProductCategory {
        return ProductCategory.valueOf(value)
    }
}
