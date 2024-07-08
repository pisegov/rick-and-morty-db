package com.myaxa.character_details.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.myaxa.character_details.ui.model.CharacterUi
import com.myaxa.character_details.ui.model.DataPoint
import com.myaxa.character_details.ui.model.UiState
import com.myaxa.core.domain.CharacterId
import com.myaxa.core.ui.components.LoadingComponent
import com.myaxa.core.ui.daggerViewModel

@Composable
internal fun CharacterDetailsScreen(
    characterId: CharacterId,
    viewModel: CharacterDetailsViewModel = daggerViewModel(),
) {
    val uiState: UiState by viewModel.characterFlow.collectAsState()

    LaunchedEffect(key1 = viewModel) { viewModel.loadCharacter(characterId) }

    when (val state = uiState) {
        is UiState.Success -> {
            CharacterDetails(
                character = state.character,
                characterDataPoints = calculateCharacterDataPoints(state.character),
            )
        }

        is UiState.Error -> {}

        UiState.Loading -> {
            LoadingComponent()
        }
    }
}

private fun calculateCharacterDataPoints(character: CharacterUi): List<DataPoint> = buildList {
    add(DataPoint("Last known location", character.location.name))
    add(DataPoint("Species", character.species))
    add(DataPoint("Gender", character.gender.stringResource))
    character.type.takeIf { it.isNotEmpty() }?.let { type ->
        add(DataPoint("Type", type))
    }
    add(DataPoint("Origin", character.origin.name))
    add(DataPoint("Episodes count", character.episodeUrls.size.toString()))
}