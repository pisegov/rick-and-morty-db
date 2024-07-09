package com.myaxa.character_details.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.myaxa.character_details.ui.model.CharacterStatusUi
import com.myaxa.core.ui.theme.RickAction

@Composable
internal fun CharacterDetailsNamePlateComponent(
    name: String,
    status: CharacterStatusUi,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 42.sp,
) {

    Column(modifier = modifier.fillMaxWidth()) {
        CharacterStatusComponent(status = status)
        Text(
            text = name,
            fontSize = textSize,
            lineHeight = textSize,
            fontWeight = FontWeight.Bold,
            color = RickAction
        )
    }
}


@Preview
@Composable
internal fun CharacterDetailsNamePlatePreview() {
    CharacterDetailsNamePlateComponent(
        name = "Abadango Cluster Princess",
        status = CharacterStatusUi.Alive
    )
}