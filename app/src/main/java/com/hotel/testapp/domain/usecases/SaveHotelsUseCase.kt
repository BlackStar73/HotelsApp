package com.hotel.testapp.domain.usecases

import com.hotel.testapp.data.local.entities.HotelEntity
import com.hotel.testapp.data.local.repository.LocalHotelRepository
import com.hotel.testapp.domain.utils.DispatchersProvider
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class SaveHotelsUseCase @Inject constructor(
    private val repository: LocalHotelRepository,
    private val dispatcher: DispatchersProvider
) {
    suspend operator fun invoke(list: List<HotelEntity>) {
        withContext(dispatcher.io) {
            repository.saveAllHotels(list)
        }
    }
}