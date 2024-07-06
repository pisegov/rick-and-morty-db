package com.myaxa.character_details.domain

import kotlinx.serialization.Serializable

@Serializable
enum class CharacterStatus {
    ALIVE, DEAD, UNKNOWN;
}