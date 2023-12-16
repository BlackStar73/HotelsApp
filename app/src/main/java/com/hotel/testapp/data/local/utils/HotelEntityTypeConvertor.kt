package com.hotel.testapp.data.local.utils

import androidx.room.TypeConverter
import com.hotel.testapp.data.local.entities.HotelEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class HotelEntityTypeConvertor {
    @TypeConverter
    fun fromHotelInfo(hotel: HotelEntity): String {
        return Json.encodeToString(hotel)
    }

    @TypeConverter
    fun toHotelInfo(hotel: String): HotelEntity {
        return Json.decodeFromString<HotelEntity>(hotel)
    }
}