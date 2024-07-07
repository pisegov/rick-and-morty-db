package com.myaxa.character_details.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myaxa.character_details.R
import com.myaxa.character_details.ui.model.CharacterStatusUi
import com.myaxa.core.ui.theme.RickTextPrimary

@Composable
internal fun CharacterStatusComponent(
    status: CharacterStatusUi,
    modifier: Modifier = Modifier
) {
    val text = stringResource(id = status.stringResource)
    Text(
        text = stringResource(id = R.string.status, text),
        color = RickTextPrimary,
        modifier = modifier
            .border(
                width = 1.dp,
                color = status.color,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(6.dp)
    )
}

@Preview
@Composable
private fun CharacterStatusComponentPreview() {
    CharacterStatusComponent(status = CharacterStatusUi.Alive)
}