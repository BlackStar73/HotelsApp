package com.hotel.testapp.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ErrorResponse(
    @SerialName("code") val code: Int,
    @SerialName("message") val message: String,
)