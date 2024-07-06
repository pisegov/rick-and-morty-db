package com.myaxa.character_details.ui.model

import com.myaxa.character_details.domain.Character
import com.myaxa.core.domain.CharacterId

internal data class CharacterUi(
    val id: CharacterId,
    val name: String,
    val created: String,
    val location: Location,
    val origin: Origin,
    val episodeUrls: List<String>,
    val imageUrl: String,
    val species: String,
    val type: String,
    val status: CharacterStatusUi,
    val gender: CharacterGenderUi,
) {
    data class Origin(val name: String)
    data class Location(val name: String)
}

internal fun Character.toUiModel() = CharacterUi(
    id = id,
    name = name,
    created = created,
    location = CharacterUi.Location(location.name),
    origin = CharacterUi.Origin(origin.name),
    episodeUrls = episodeUrls,
    imageUrl = imageUrl,
    species = species,
    type = type,
    status = status.toUiModel(),
    gender = gender.toUiModel(),
)