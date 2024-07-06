package com.myaxa.character_details.ui.model

import com.myaxa.character_details.R
import com.myaxa.character_details.domain.CharacterGender

internal sealed class CharacterGenderUi(stringResource: Int) {
    data object Female : CharacterGenderUi(R.string.female)
    data object Male : CharacterGenderUi(R.string.male)
    data object Genderless : CharacterGenderUi(R.string.genderless)
    data object Unknown : CharacterGenderUi(R.string.unknown)
}

internal fun CharacterGender.toUiModel() = when (this) {
    CharacterGender.FEMALE -> CharacterGenderUi.Female
    CharacterGender.MALE -> CharacterGenderUi.Male
    CharacterGender.GENDERLESS -> CharacterGenderUi.Genderless
    CharacterGender.UNKNOWN -> CharacterGenderUi.Unknown
}