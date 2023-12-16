package com.hotel.testapp.domain.usecases

import com.haroldadmin.cnradapter.NetworkResponse
import com.hotel.testapp.data.local.repository.LocalHotelRepository
import com.hotel.testapp.data.model.DataResult
import com.hotel.testapp.data.network.repository.HotelRepository
import com.hotel.testapp.domain.models.HotelModel
import com.hotel.testapp.domain.models.toDomain
import com.hotel.testapp.domain.utils.DispatchersProvider
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class HotelUseCase @Inject constructor(
    private val repository: HotelRepository,
    private val localRepository: LocalHotelRepository,
    private val dispatcher: DispatchersProvider
) {
    suspend operator fun invoke(): DataResult<HotelModel, String> {
        return withContext(dispatcher.io) {
            when (val result = repository.getAllHotels()) {
                is NetworkResponse.Success -> {
                    // localRepository.saveAllHotels(result.body.toDomain().)
                    DataResult.Success(result.body.toDomain())
                }

                is NetworkResponse.ServerError -> DataResult.Error(result.body?.message ?: "")
                else -> DataResult.Error("")
            }
        }
    }
}