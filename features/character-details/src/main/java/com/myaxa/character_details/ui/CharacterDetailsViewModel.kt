package com.myaxa.character_details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myaxa.character_details.data.CharacterDetailsRepository
import com.myaxa.character_details.ui.model.UiState
import com.myaxa.character_details.ui.model.toUiModel
import com.myaxa.core.domain.CharacterId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CharacterDetailsViewModel @Inject constructor(
    private val repository: CharacterDetailsRepository,
) : ViewModel() {

    private val _characterFlow = MutableStateFlow<UiState>(UiState.Loading)
    val characterFlow = _characterFlow.asStateFlow()

    fun loadCharacter(id: CharacterId) {
        viewModelScope.launch {
            repository.getCharacter(id)
                .onSuccess { model ->
                    _characterFlow.emit(UiState.Success(character = model.toUiModel()))
                }
                .onFailure { throwable ->
                    _characterFlow.emit(UiState.Error(e = throwable))
                }
        }
    }
}
