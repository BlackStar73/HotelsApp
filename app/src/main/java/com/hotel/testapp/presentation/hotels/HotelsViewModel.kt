package com.hotel.testapp.presentation.hotels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hotel.testapp.data.model.DataResult
import com.hotel.testapp.domain.usecases.GetHotelUseCase
import com.hotel.testapp.domain.usecases.GetLocalHotelsUseCase
import com.hotel.testapp.domain.usecases.SaveHotelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelsViewModel @Inject constructor(
    private val getHotelUseCase: GetHotelUseCase,
    private val saveHotelsUseCase: SaveHotelsUseCase,
    private val getLocalHotelsUseCase: GetLocalHotelsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HotelsUiState())
    val state = _state.asStateFlow()

    init {
        syncData()
    }

    private fun syncData() {
        viewModelScope.launch {
            _state.update { it.copy(screenState = ScreenState.Loading) }

            when (val result = getHotelUseCase()) {
                is DataResult.Success -> {

                    saveHotelsUseCase(state.value.content)

                    _state.update {
                        it.copy(
                            content = result.data,
                            screenState = ScreenState.Content
                        )
                    }
                }

                is DataResult.Error -> {
                    _state.update {
                        it.copy(
                            errorMessage = result.data,
                            content = getLocalHotelsUseCase(),
                            screenState = ScreenState.Content,
                            isEmpty = getLocalHotelsUseCase().isEmpty()
                        )
                    }
                }
            }
        }
    }
}