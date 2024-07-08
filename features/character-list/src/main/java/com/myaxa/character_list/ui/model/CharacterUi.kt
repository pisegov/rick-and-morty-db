package com.myaxa.character_list.ui.model

import com.myaxa.character_data.domain.Character
import com.myaxa.core.domain.CharacterId

internal data class CharacterUi(
    val id: CharacterId,
    val name: String,
    val imageUrl: String,
    val status: CharacterStatusUi,
)

internal fun Character.toUiModel() = CharacterUi(
    id = id,
    name = name,
    imageUrl = imageUrl,
    status = status.toUiModel(),
)