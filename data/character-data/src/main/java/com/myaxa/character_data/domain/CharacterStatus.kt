package com.myaxa.character_data.domain

import kotlinx.serialization.Serializable

@Serializable
enum class CharacterStatus {
    ALIVE, DEAD, UNKNOWN;
}