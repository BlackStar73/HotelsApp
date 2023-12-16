package com.hotel.testapp.domain.models

import com.hotel.testapp.data.model.response.HotelResponse

data class HotelModel(
    val id: Int,
    val aboutTheHotel: HotelInfoModel,
    val address: String,
    val imageUrls: List<String>,
    val minimalPrice: Int,
    val name: String,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String
)

fun HotelResponse.toDomain(): HotelModel = HotelModel(
    id = id,
    aboutTheHotel = aboutTheHotel.toDomain(),
    address = "",
    imageUrls = listOf(),
    minimalPrice = 0,
    name = "",
    priceForIt = "",
    rating = 0,
    ratingName = ""
)
