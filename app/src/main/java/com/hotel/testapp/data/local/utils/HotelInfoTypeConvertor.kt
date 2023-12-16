package com.hotel.testapp.data.local.utils

import androidx.room.TypeConverter
import com.hotel.testapp.data.local.entities.HotelInfo
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class HotelInfoTypeConvertor {
    @TypeConverter
    fun fromHotelInfo(hotel: HotelInfo): String {
        return Json.encodeToString(hotel)
    }

    @TypeConverter
    fun toHotelInfo(hotel: String): HotelInfo {
        return Json.decodeFromString<HotelInfo>(hotel)
    }
}