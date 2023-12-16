package com.hotel.testapp.data.local.entities

import com.hotel.testapp.data.model.response.HotelInfoResponse
import kotlinx.serialization.Serializable

@Serializable
data class HotelInfo(
    val description: String,
    val peculiarities: List<String>
)

fun HotelInfoResponse.toEntity(): HotelInfo =
    HotelInfo(description = description, peculiarities = peculiarities)
