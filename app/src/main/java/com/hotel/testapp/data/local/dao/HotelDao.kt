package com.hotel.testapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hotel.testapp.data.local.entities.HotelEntity

@Dao
interface HotelDao {

    @Query("SELECT * FROM HotelEntity")
    suspend fun getAllHotels(): List<HotelEntity>

    @Query("SELECT * FROM HotelEntity where id=:id")
    suspend fun getHotelById(id: Int): HotelEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllHotels(reason: List<HotelEntity>)

    @Query("DELETE FROM HotelEntity")
    suspend fun deleteAllHotels()
}