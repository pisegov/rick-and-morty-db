package com.myaxa.character_list.ui.model

internal sealed interface UiState {

    data class Success(
        val list: List<CharacterUi>,
        val pageNumber: Int,
        val totalPagesNumber: Int,
    ) : UiState

    data class Error(val message: String?) : UiState

    data object Loading : UiState
}