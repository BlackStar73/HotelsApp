package com.hotel.testapp.domain.models

import com.hotel.testapp.data.model.response.RoomResponse

data class RoomModel(
    val id: Int,
    val imageUrls: List<String>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val pricePer: String
)

fun RoomResponse.toDomain(): RoomModel = RoomModel(
    id = id,
    imageUrls = imageUrls,
    name = name,
    peculiarities = peculiarities,
    price = price,
    pricePer = pricePer
)