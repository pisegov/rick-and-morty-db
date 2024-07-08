package com.myaxa.character_details.ui.model

import androidx.compose.ui.graphics.Color
import com.myaxa.core.ui.R as CoreUiR
import com.myaxa.character_data.domain.CharacterStatus

internal sealed class CharacterStatusUi(val stringResource: Int, val color: Color) {
    data object Alive : CharacterStatusUi(CoreUiR.string.alive, Color.Green)
    data object Dead : CharacterStatusUi(CoreUiR.string.dead, Color.Red)
    data object Unknown : CharacterStatusUi(CoreUiR.string.unknown, Color.Yellow)
}

internal fun CharacterStatus.toUiModel() = when (this) {
    CharacterStatus.ALIVE -> CharacterStatusUi.Alive
    CharacterStatus.DEAD -> CharacterStatusUi.Dead
    CharacterStatus.UNKNOWN -> CharacterStatusUi.Unknown
}