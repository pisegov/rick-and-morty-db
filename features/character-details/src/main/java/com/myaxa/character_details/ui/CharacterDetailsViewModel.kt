package com.myaxa.character_details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myaxa.character_details.data.CharacterDTO
import com.myaxa.character_details.data.CharacterDetailsNetworkDataSource
import com.myaxa.core.domain.CharacterId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val networkDataSource: CharacterDetailsNetworkDataSource,
) : ViewModel() {

    private val _characterFlow = MutableStateFlow<CharacterDTO?>(null)
    internal val characterFlow = _characterFlow.asStateFlow()

    internal fun loadCharacter(id: CharacterId) {
        viewModelScope.launch {
            _characterFlow.emit(networkDataSource.getCharacter(id))
        }
    }
}
