package com.myaxa.character_details.data.network.model

import com.myaxa.character_details.domain.CharacterStatus
import com.myaxa.core.data.EnumAsStringSerializer
import kotlinx.serialization.Serializable

@Serializable(with = CharacterStatusSerializer::class)
internal enum class CharacterStatusDTO(val value: String) {
    ALIVE("Alive"),

    DEAD("Dead"),

    UNKNOWN("unknown"),
    ;
}

/**
 * Need to deserialize any unsupported status as unknown
 */
private class CharacterStatusSerializer : EnumAsStringSerializer<CharacterStatusDTO>(
    serialName = "CharacterStatusSerializer",
    serialize = { v -> v.value },
    deserialize = { v ->
        CharacterStatusDTO.entries.firstOrNull { v == it.value } ?: CharacterStatusDTO.UNKNOWN
    },
)

internal fun CharacterStatusDTO.toDomainModel() = when(this) {
    CharacterStatusDTO.ALIVE -> CharacterStatus.ALIVE
    CharacterStatusDTO.DEAD -> CharacterStatus.DEAD
    CharacterStatusDTO.UNKNOWN -> CharacterStatus.UNKNOWN
}