package com.hotel.testapp.data.network.repository.impl

import com.haroldadmin.cnradapter.NetworkResponse
import com.hotel.testapp.data.model.response.AllRoomsResponse
import com.hotel.testapp.data.model.response.ErrorResponse
import com.hotel.testapp.data.model.response.HotelResponse
import com.hotel.testapp.data.network.ApiService
import com.hotel.testapp.data.network.repository.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val service: ApiService
) : HotelRepository {
    override suspend fun getAllHotels(): NetworkResponse<List<HotelResponse>, ErrorResponse> {
        return service.getHotels()
    }

    override suspend fun getAllRooms(): NetworkResponse<AllRoomsResponse, ErrorResponse> {
        return service.getRooms()
    }
}