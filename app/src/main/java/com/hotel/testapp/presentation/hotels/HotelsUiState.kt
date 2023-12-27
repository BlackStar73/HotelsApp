package com.hotel.testapp.presentation.hotels

import com.hotel.testapp.data.local.entities.HotelEntity


data class HotelsUiState(
    val screenState: ScreenState = ScreenState.IDLE,
    val errorMessage: String? = "",
    val isEmpty: Boolean = false,
    val content: List<HotelEntity> = emptyList()
)

enum class ScreenState {
    IDLE, Loading, Content, Error
}