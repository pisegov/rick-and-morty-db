package com.myaxa.character_data.data.network.model

import com.myaxa.character_data.domain.CharacterGender
import com.myaxa.network.util.EnumAsStringSerializer
import kotlinx.serialization.Serializable

@Serializable(with = CharacterGenderSerializer::class)
enum class CharacterGenderDTO(val remoteString: String) {
    FEMALE("Female"),

    MALE("Male"),

    GENDERLESS("Genderless"),

    UNKNOWN("unknown"),
    ;
}

/**
 * Need to deserialize any unsupported gender as unknown
 */
private class CharacterGenderSerializer : EnumAsStringSerializer<CharacterGenderDTO>(
    serialName = "CharacterStatusSerializer",
    serialize = { v -> v.remoteString },
    deserialize = { v ->
        CharacterGenderDTO.entries.firstOrNull { v == it.remoteString }
            ?: CharacterGenderDTO.UNKNOWN
    },
)

internal fun CharacterGenderDTO.toDomainModel() = when (this) {
    CharacterGenderDTO.FEMALE -> CharacterGender.FEMALE
    CharacterGenderDTO.MALE -> CharacterGender.MALE
    CharacterGenderDTO.GENDERLESS -> CharacterGender.GENDERLESS
    CharacterGenderDTO.UNKNOWN -> CharacterGender.UNKNOWN
}