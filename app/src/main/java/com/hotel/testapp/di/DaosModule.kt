package com.hotel.testapp.di

import android.content.Context
import androidx.room.Room
import com.hotel.testapp.data.local.AppDatabase
import com.hotel.testapp.data.local.dao.HotelDao
import com.hotel.testapp.data.local.dao.RoomsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaosModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase = Room.databaseBuilder(
        appContext, AppDatabase::class.java, "hotel_db"
    ).fallbackToDestructiveMigration().build()


    @Provides
    fun provideHotelDao(database: AppDatabase): HotelDao {
        return database.hotelDao()
    }

    @Provides
    fun provideRoomDao(database: AppDatabase): RoomsDao {
        return database.roomsDao()
    }
}