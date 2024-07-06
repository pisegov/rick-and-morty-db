package com.myaxa.character_details.ui.model

import androidx.compose.ui.graphics.Color
import com.myaxa.character_details.R
import com.myaxa.character_details.domain.CharacterStatus

internal sealed class CharacterStatusUi(stringResource: Int, color: Color) {
    data object Alive : CharacterStatusUi(R.string.alive, Color.Green)
    data object Dead : CharacterStatusUi(R.string.dead, Color.Red)
    data object Unknown : CharacterStatusUi(R.string.unknown, Color.Yellow)
}

internal fun CharacterStatus.toUiModel() = when (this) {
    CharacterStatus.ALIVE -> CharacterStatusUi.Alive
    CharacterStatus.DEAD -> CharacterStatusUi.Dead
    CharacterStatus.UNKNOWN -> CharacterStatusUi.Unknown
}