package com.myaxa.characters.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myaxa.characters.data.CharacterDTO
import com.myaxa.characters.data.CharactersNetworkDataSource
import com.myaxa.characters.domain.CharacterId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CharactersViewModel @Inject constructor(
    private val networkDataSource: CharactersNetworkDataSource,
) : ViewModel() {

    private val _characterFlow = MutableStateFlow<CharacterDTO?>(null)
    val characterFlow = _characterFlow.asStateFlow()

    fun loadCharacter(id: CharacterId) {
        viewModelScope.launch {
            _characterFlow.emit(networkDataSource.getCharacter(id))
        }
    }
}
