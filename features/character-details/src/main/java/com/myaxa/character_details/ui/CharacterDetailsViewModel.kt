package com.myaxa.character_details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myaxa.character_details.data.CharacterDetailsRepository
import com.myaxa.character_details.ui.model.CharacterUi
import com.myaxa.character_details.ui.model.toUiModel
import com.myaxa.core.domain.CharacterId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CharacterDetailsViewModel @Inject constructor(
    private val repository: CharacterDetailsRepository,
) : ViewModel() {

    private val _characterFlow = MutableStateFlow<CharacterUi?>(null)
    val characterFlow = _characterFlow.asStateFlow()

    fun loadCharacter(id: CharacterId) {
        viewModelScope.launch {
            _characterFlow.emit(repository.getCharacter(id).toUiModel())
        }
    }
}
