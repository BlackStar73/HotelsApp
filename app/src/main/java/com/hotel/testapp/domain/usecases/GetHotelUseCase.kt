package com.hotel.testapp.domain.usecases

import com.haroldadmin.cnradapter.NetworkResponse
import com.hotel.testapp.data.local.entities.HotelEntity
import com.hotel.testapp.data.local.entities.toEntity
import com.hotel.testapp.data.model.DataResult
import com.hotel.testapp.data.network.repository.HotelRepository
import com.hotel.testapp.domain.utils.DispatchersProvider
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class GetHotelUseCase @Inject constructor(
    private val repository: HotelRepository,
    private val dispatcher: DispatchersProvider
) {
    suspend operator fun invoke(): DataResult<List<HotelEntity>, String> {
        return withContext(dispatcher.io) {
            when (val result = repository.getAllHotels()) {
                is NetworkResponse.Success -> {
                    DataResult.Success(result.body.map {
                        it.toEntity()
                    })
                }

                is NetworkResponse.NetworkError -> DataResult.Error(result.body?.message ?: "")
                is NetworkResponse.ServerError -> DataResult.Error(result.body?.message ?: "")
                is NetworkResponse.UnknownError -> DataResult.Error(result.body?.message ?: "")
                else -> DataResult.Error("")
            }
        }
    }
}