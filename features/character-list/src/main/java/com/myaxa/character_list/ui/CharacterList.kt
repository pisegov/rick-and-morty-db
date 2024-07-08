package com.myaxa.character_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myaxa.character_list.ui.components.CharacterListItem
import com.myaxa.character_list.ui.model.CharacterUi

@Composable
internal fun CharacterList(
    characterList: List<CharacterUi>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2),
        modifier = modifier
            .safeDrawingPadding()
    ) {
        items(items = characterList, key = { it.id }) {
            CharacterListItem(
                character = it,
                modifier = Modifier
                    .clickable { }
            )
        }
    }
}
