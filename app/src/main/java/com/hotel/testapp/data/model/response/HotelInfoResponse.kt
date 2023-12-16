package com.hotel.testapp.data.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotelInfoResponse(
    @SerialName("description")
    val description: String,
    @SerialName("peculiarities")
    val peculiarities: List<String>
)