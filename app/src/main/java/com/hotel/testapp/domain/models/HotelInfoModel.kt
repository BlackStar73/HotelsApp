package com.hotel.testapp.domain.models

import com.hotel.testapp.data.model.response.HotelInfoResponse

data class HotelInfoModel(
    val description: String,
    val peculiarities: List<String>
)

fun HotelInfoResponse.toDomain(): HotelInfoModel = HotelInfoModel(
    description = description, peculiarities = peculiarities

)