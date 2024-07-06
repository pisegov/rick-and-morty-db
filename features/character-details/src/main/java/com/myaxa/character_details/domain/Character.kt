package com.myaxa.character_details.domain

import com.myaxa.core.domain.CharacterId

internal data class Character(
    val id: CharacterId,
    val name: String,
    val created: String,
    val origin: Origin,
    val location: Location,
    val episodeUrls: List<String>,
    val imageUrl: String,
    val species: String,
    val type: String,
    val status: CharacterStatus,
    val gender: CharacterGender,
) {

    data class Origin(val name: String, val url: String)
    data class Location(val name: String, val url: String)
}
