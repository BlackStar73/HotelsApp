package com.hotel.testapp.data.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotelResponse(
    @SerialName("id") var id: Int,
    @SerialName("name") var name: String,
    @SerialName("address") var address: String,
    @SerialName("minimal_price") var minimalPrice: Int,
    @SerialName("price_for_it") var priceForIt: String,
    @SerialName("rating") var rating: Int,
    @SerialName("rating_name") var ratingName: String,
    @SerialName("image_urls") var imageUrls: ArrayList<String> = arrayListOf(),
    @SerialName("about_the_hotel") var aboutTheHotel: HotelInfoResponse
)
