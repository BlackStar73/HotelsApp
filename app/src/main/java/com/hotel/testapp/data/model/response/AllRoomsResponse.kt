package com.hotel.testapp.data.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllRoomsResponse(
    @SerialName("rooms")
    val rooms: List<RoomResponse>
)