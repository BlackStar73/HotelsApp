package com.hotel.testapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hotel.testapp.data.model.response.HotelResponse

@Entity
data class HotelEntity(
    @PrimaryKey val id: Int,
    val aboutTheHotel: HotelInfo,
    val address: String,
    val imageUrls: List<String>,
    val minimalPrice: Int,
    val name: String,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String
)

fun HotelResponse.toEntity(): HotelEntity = HotelEntity(
    id = id,
    aboutTheHotel = aboutTheHotel.toEntity(),
    address = adress,
    imageUrls = imageUrls,
    minimalPrice = minimalPrice,
    name = name,
    priceForIt = priceForIt,
    rating = rating,
    ratingName = ratingName
)