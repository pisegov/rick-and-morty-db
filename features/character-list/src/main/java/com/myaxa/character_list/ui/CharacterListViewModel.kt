package com.myaxa.character_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myaxa.character_data.data.CharacterRepository
import com.myaxa.character_data.domain.Character
import com.myaxa.character_list.ui.model.CharacterUi
import com.myaxa.character_list.ui.model.toUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository,
) : ViewModel() {

    companion object {
        private const val INITIAL_PAGE_NUMBER = 1
    }

    private val _characterListFlow = MutableStateFlow<UiState>(UiState.Loading)
    val characterListFlow = _characterListFlow.asStateFlow()

    fun loadInitialPage() = viewModelScope.launch {
        repository.loadCharacterListPage(INITIAL_PAGE_NUMBER)
            .onSuccess { list: List<Character> ->
                _characterListFlow.emit(UiState.Success(list.map { it.toUiModel() }))
            }
            .onFailure { throwable ->
                _characterListFlow.emit(UiState.Error(throwable.message))
            }
    }
}

internal sealed interface UiState {
    data class Success(val list: List<CharacterUi>) : UiState
    data class Error(val message: String?) : UiState
    data object Loading : UiState
}
