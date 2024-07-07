package com.myaxa.character_details.ui.model

internal sealed interface UiState {
    data class Success(val data: CharacterUi) : UiState
    data class Error(val e: Throwable) : UiState
    data object Loading : UiState
}
