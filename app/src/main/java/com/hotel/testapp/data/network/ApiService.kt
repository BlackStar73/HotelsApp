package com.hotel.testapp.data.network

import com.haroldadmin.cnradapter.NetworkResponse
import com.hotel.testapp.data.model.response.AllRoomsResponse
import com.hotel.testapp.data.model.response.ErrorResponse
import com.hotel.testapp.data.model.response.HotelResponse
import retrofit2.http.GET

interface ApiService {

    @GET("5fdbd99e-4453-43f8-8bb7-5190d9a77f10")
    suspend fun getHotels(): NetworkResponse<List<HotelResponse>, ErrorResponse>

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRooms(): NetworkResponse<AllRoomsResponse, ErrorResponse>
}