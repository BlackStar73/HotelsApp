package com.hotel.testapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hotel.testapp.data.model.response.RoomResponse

@Entity
data class RoomsEntity(
    @PrimaryKey val id: Int,
    val imageUrls: List<String>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val pricePer: String
)

fun RoomResponse.toEntity(): RoomsEntity = RoomsEntity(
    id = id,
    imageUrls = imageUrls,
    name = name,
    peculiarities = peculiarities,
    price = price,
    pricePer = pricePer
)