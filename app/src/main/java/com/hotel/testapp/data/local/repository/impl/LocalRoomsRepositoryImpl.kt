package com.hotel.testapp.data.local.repository.impl

import com.hotel.testapp.data.local.dao.RoomsDao
import com.hotel.testapp.data.local.entities.RoomsEntity
import com.hotel.testapp.data.local.repository.LocalRoomsRepository
import javax.inject.Inject

class LocalRoomsRepositoryImpl @Inject constructor(
    private val dao: RoomsDao
) : LocalRoomsRepository {
    override suspend fun getAllRooms(): List<RoomsEntity> {
        return dao.getAllRooms()
    }

    override suspend fun saveAllRooms(rooms: List<RoomsEntity>) {
        dao.saveAllRooms(rooms)
    }

    override suspend fun getRoomById(id: Int): RoomsEntity {
        return dao.getRoomById(id)
    }

    override suspend fun deleteAllRooms() {
        dao.deleteAllRooms()
    }
}
