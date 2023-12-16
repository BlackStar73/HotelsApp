package com.hotel.testapp.data.local.repository

import com.hotel.testapp.data.local.entities.RoomsEntity

interface LocalRoomsRepository {
    suspend fun getAllRooms(): List<RoomsEntity>

    suspend fun saveAllRooms(rooms: List<RoomsEntity>)

    suspend fun getRoomById(id: Int): RoomsEntity

    suspend fun deleteAllRooms()
}