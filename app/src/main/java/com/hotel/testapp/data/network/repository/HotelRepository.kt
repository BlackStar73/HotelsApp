package com.hotel.testapp.data.network.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.hotel.testapp.data.model.response.AllRoomsResponse
import com.hotel.testapp.data.model.response.ErrorResponse
import com.hotel.testapp.data.model.response.HotelResponse

interface HotelRepository {
    suspend fun getAllHotels(): NetworkResponse<List<HotelResponse>, ErrorResponse>

    suspend fun getAllRooms(): NetworkResponse<AllRoomsResponse, ErrorResponse>
}