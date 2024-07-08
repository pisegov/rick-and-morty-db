package com.myaxa.character_details.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myaxa.character_details.ui.components.CharacterDetailsNamePlateComponent
import com.myaxa.character_details.ui.components.DataPointComponent
import com.myaxa.character_details.ui.model.CharacterUi
import com.myaxa.character_details.ui.model.DataPoint
import com.myaxa.core.ui.components.CharacterImage

@Composable
internal fun CharacterDetails(
    character: CharacterUi,
    characterDataPoints: List<DataPoint>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp)
            .safeDrawingPadding()
    )
    {
        item {
            CharacterDetailsNamePlateComponent(name = character.name, status = character.status)
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        item { CharacterImage(imageUrl = character.imageUrl) }

        items(characterDataPoints) {
            Spacer(modifier = Modifier.height(32.dp))
            DataPointComponent(dataPoint = it)
        }

        item { Spacer(modifier = Modifier.height(32.dp)) }
    }
}