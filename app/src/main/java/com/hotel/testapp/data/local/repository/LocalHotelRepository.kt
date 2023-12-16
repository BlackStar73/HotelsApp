package com.hotel.testapp.data.local.repository

import com.hotel.testapp.data.local.entities.HotelEntity

interface LocalHotelRepository {
    suspend fun getAllHotels(): List<HotelEntity>

    suspend fun saveAllHotels(hotels: List<HotelEntity>)

    suspend fun getHotelById(id: Int): HotelEntity

    suspend fun deleteAllHotels()
}