package com.myaxa.character_list.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myaxa.character_list.ui.model.CharacterStatusUi

@Composable
internal fun CharacterStatusIcon(
    status: CharacterStatusUi,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                brush = Brush.radialGradient(listOf(Color.Black, Color.Transparent)),
                shape = CircleShape
            )
            .size(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(
                    color = status.color,
                    shape = CircleShape
                )
        )
    }
}

@Preview
@Composable
private fun CharacterStatusIconPreview() {
    Column {
        CharacterStatusIcon(status = CharacterStatusUi.Alive)
        CharacterStatusIcon(status = CharacterStatusUi.Unknown)
        CharacterStatusIcon(status = CharacterStatusUi.Dead)
    }
}