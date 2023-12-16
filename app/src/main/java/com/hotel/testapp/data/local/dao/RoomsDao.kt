package com.hotel.testapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hotel.testapp.data.local.entities.RoomsEntity

@Dao
interface RoomsDao {
    @Query("SELECT * FROM RoomsEntity")
    suspend fun getAllRooms(): List<RoomsEntity>

    @Query("SELECT * FROM RoomsEntity where id=:id")
    suspend fun getRoomById(id: Int): RoomsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllRooms(reason: List<RoomsEntity>)

    @Query("DELETE FROM RoomsEntity")
    suspend fun deleteAllRooms()
}