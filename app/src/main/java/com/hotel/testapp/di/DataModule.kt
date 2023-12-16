package com.hotel.testapp.di

import android.content.Context
import androidx.room.Room
import com.hotel.testapp.data.local.AppDatabase
import com.hotel.testapp.data.local.repository.LocalHotelRepository
import com.hotel.testapp.data.local.repository.LocalRoomsRepository
import com.hotel.testapp.data.local.repository.impl.LocalHotelRepositoryImpl
import com.hotel.testapp.data.local.repository.impl.LocalRoomsRepositoryImpl
import com.hotel.testapp.data.network.repository.HotelRepository
import com.hotel.testapp.data.network.repository.impl.HotelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindHotelRepository(repository: HotelRepositoryImpl): HotelRepository

    @Binds
    @Singleton
    fun bindLocalHotelsRepository(repository: LocalHotelRepositoryImpl): LocalHotelRepository

    @Binds
    @Singleton
    fun bindLocalRoomsRepository(repository: LocalRoomsRepositoryImpl): LocalRoomsRepository
}