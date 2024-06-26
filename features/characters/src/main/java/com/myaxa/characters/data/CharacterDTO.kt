package com.myaxa.characters.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("origin") val origin: OriginDTO,
) {
    @Serializable
    data class OriginDTO(@SerialName("name") val name: String)
}