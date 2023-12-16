package com.hotel.testapp.data.local.utils

import androidx.room.TypeConverter

class StringListTypeConvertor {
    @TypeConverter
    fun fromListString(list: List<String>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun toListString(data: String): List<String> {
        return data.split(",")
    }
}