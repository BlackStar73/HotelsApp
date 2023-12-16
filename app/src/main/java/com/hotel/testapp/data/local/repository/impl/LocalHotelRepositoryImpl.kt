package com.hotel.testapp.data.local.repository.impl

import com.hotel.testapp.data.local.dao.HotelDao
import com.hotel.testapp.data.local.entities.HotelEntity
import com.hotel.testapp.data.local.repository.LocalHotelRepository
import javax.inject.Inject

class LocalHotelRepositoryImpl @Inject constructor(
    private val dao: HotelDao
) : LocalHotelRepository {
    override suspend fun getAllHotels(): List<HotelEntity> {
        return dao.getAllHotels()
    }

    override suspend fun saveAllHotels(hotels: List<HotelEntity>) {
        dao.saveAllHotels(hotels)
    }

    override suspend fun getHotelById(id: Int): HotelEntity {
        return dao.getHotelById(id)
    }

    override suspend fun deleteAllHotels() {
        dao.deleteAllHotels()
    }
}
