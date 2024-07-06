package com.myaxa.character_details.data

import com.myaxa.core.domain.CharacterId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharacterDTO(
    @SerialName("id") val id: CharacterId,
    @SerialName("name") val name: String,
    @SerialName("origin") val origin: OriginDTO,
) {
    @Serializable
    data class OriginDTO(@SerialName("name") val name: String)
}