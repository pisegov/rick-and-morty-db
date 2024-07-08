package com.myaxa.character_data.domain

import kotlinx.serialization.Serializable

@Serializable
enum class CharacterGender {
    FEMALE, MALE, GENDERLESS, UNKNOWN;
}