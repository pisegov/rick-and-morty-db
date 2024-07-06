package com.myaxa.character_details.domain

import kotlinx.serialization.Serializable

@Serializable
enum class CharacterGender {
    FEMALE, MALE, GENDERLESS, UNKNOWN;
}