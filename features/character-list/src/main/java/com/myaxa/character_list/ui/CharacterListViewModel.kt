package com.myaxa.character_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myaxa.character_data.data.CharacterRepository
import com.myaxa.character_list.ui.model.UiState
import com.myaxa.character_list.ui.model.toUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    fun loadInitialPage() {
        if (_characterListFlow.value != UiState.Loading) return
        loadPage(INITIAL_PAGE_NUMBER)
    }

    fun loadNextPage(pageNumber: Int) {
        loadPage(pageNumber + 1)
    }

    private fun loadPage(pageNumber: Int) = viewModelScope.launch {
        repository.loadCharacterListPage(pageNumber)

            .onSuccess { page ->

                _characterListFlow.update { state ->

                    val newList = page.list.map { it.toUiModel() }

                    if (state !is UiState.Success || pageNumber == INITIAL_PAGE_NUMBER) {
                        return@update UiState.Success(
                            list = newList,
                            pageNumber = INITIAL_PAGE_NUMBER,
                            totalPagesNumber = page.totalPagesNumber
                        )
                    }

                    state.copy(list = state.list + newList, pageNumber = state.pageNumber + 1)
                }
            }
            .onFailure { throwable ->
                _characterListFlow.update { UiState.Error(throwable.message) }
            }
    }
}

