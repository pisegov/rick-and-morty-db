package com.myaxa.character_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myaxa.character_list.ui.components.CharacterListItem
import com.myaxa.character_list.ui.model.CharacterUi
import com.myaxa.core.domain.CharacterId

@Composable
internal fun CharacterList(
    characterList: List<CharacterUi>,
    modifier: Modifier = Modifier,
    onCharacterClicked: (CharacterId) -> Unit = {},
) {
    LazyVerticalStaggeredGrid(
        contentPadding = PaddingValues(16.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier
            .safeDrawingPadding()
    ) {
        items(items = characterList, key = { it.id }) { model ->
            CharacterListItem(
                character = model,
                modifier = Modifier
                    .clickable { onCharacterClicked(model.id) }
            )
        }
    }
}
