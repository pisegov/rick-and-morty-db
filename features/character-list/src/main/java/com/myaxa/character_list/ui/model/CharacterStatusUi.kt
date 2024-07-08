package com.myaxa.character_list.ui.model

import androidx.compose.ui.graphics.Color
import com.myaxa.character_data.domain.CharacterStatus

internal sealed class CharacterStatusUi(val color: Color) {
    data object Alive : CharacterStatusUi(Color.Green)
    data object Dead : CharacterStatusUi(Color.Red)
    data object Unknown : CharacterStatusUi(Color.Yellow)
}

internal fun CharacterStatus.toUiModel() = when (this) {
    CharacterStatus.ALIVE -> CharacterStatusUi.Alive
    CharacterStatus.DEAD -> CharacterStatusUi.Dead
    CharacterStatus.UNKNOWN -> CharacterStatusUi.Unknown
}