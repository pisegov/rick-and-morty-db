package com.myaxa.character_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myaxa.character_data.data.CharacterRepository
import com.myaxa.character_data.domain.Character
import com.myaxa.core.domain.CharacterId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository,
) : ViewModel() {

    private val _characterFlow = MutableStateFlow<Result<Character>?>(null)
    val characterFlow = _characterFlow.asStateFlow()

    fun loadCharacter(id: CharacterId) {
        viewModelScope.launch {
            _characterFlow.emit(repository.getCharacter(id))
        }
    }
}
