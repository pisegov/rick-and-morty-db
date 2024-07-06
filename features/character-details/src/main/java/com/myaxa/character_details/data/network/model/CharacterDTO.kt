package com.myaxa.character_details.data.network.model

import com.myaxa.character_details.domain.Character
import com.myaxa.character_details.domain.Character.Location
import com.myaxa.character_details.domain.Character.Origin
import com.myaxa.core.domain.CharacterId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharacterDTO(
    @SerialName("id") val id: CharacterId,
    @SerialName("name") val name: String,
    @SerialName("origin") val origin: OriginDTO,
    @SerialName("created") val created: String,
    @SerialName("location") val location: LocationDTO,
    @SerialName("episode") val episodeUrls: List<String>,
    @SerialName("image") val imageUrl: String,
    @SerialName("species") val species: String,
    @SerialName("type") val type: String,
    @SerialName("status") val status: CharacterStatusDTO,
    @SerialName("gender") val gender: CharacterGenderDTO,
) {
    @Serializable
    data class OriginDTO(
        @SerialName("name") val name: String,
        @SerialName("url") val url: String,
    )

    @Serializable
    data class LocationDTO(
        @SerialName("name") val name: String,
        @SerialName("url") val url: String,
    )
}

internal fun CharacterDTO.toDomainModel() = Character(
    id = id,
    name = name,
    created = created,
    location = Location(location.name, location.url),
    origin = Origin(origin.name, location.url),
    episodeUrls = episodeUrls,
    imageUrl = imageUrl,
    species = species,
    type = type,
    status = status.toDomainModel(),
    gender = gender.toDomainModel(),
)