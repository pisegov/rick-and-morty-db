package com.myaxa.character_details.ui.model

import com.myaxa.character_data.domain.CharacterGender
import com.myaxa.core.ui.R as CoreUiR

internal sealed class CharacterGenderUi(val stringResource: Int) {
    data object Female : CharacterGenderUi(CoreUiR.string.female)
    data object Male : CharacterGenderUi(CoreUiR.string.male)
    data object Genderless : CharacterGenderUi(CoreUiR.string.genderless)
    data object Unknown : CharacterGenderUi(CoreUiR.string.unknown)
}

internal fun CharacterGender.toUiModel() = when (this) {
    CharacterGender.FEMALE -> CharacterGenderUi.Female
    CharacterGender.MALE -> CharacterGenderUi.Male
    CharacterGender.GENDERLESS -> CharacterGenderUi.Genderless
    CharacterGender.UNKNOWN -> CharacterGenderUi.Unknown
}