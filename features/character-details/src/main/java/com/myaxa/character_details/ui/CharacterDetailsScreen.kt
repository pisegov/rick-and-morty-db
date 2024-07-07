package com.myaxa.character_details.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.myaxa.character_details.ui.components.CharacterDetailsNamePlateComponent
import com.myaxa.character_details.ui.components.DataPointComponent
import com.myaxa.character_details.ui.model.CharacterUi
import com.myaxa.character_details.ui.model.DataPoint
import com.myaxa.character_details.ui.model.UiState
import com.myaxa.core.ui.components.LoadingComponent

@Composable
internal fun CharacterDetailsScreen(
    viewModel: CharacterDetailsViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState: UiState by viewModel.characterFlow.collectAsState()

    val characterDataPoints: List<DataPoint> by remember {
        derivedStateOf {
            buildList {
                when (val state = uiState) {
                    is UiState.Success -> {
                        add(DataPoint("Last known location", state.data.location.name))
                        add(DataPoint("Species", state.data.species))
                        add(DataPoint("Gender", state.data.gender.stringResource))
                        state.data.type.takeIf { it.isNotEmpty() }?.let { type ->
                            add(DataPoint("Type", type))
                        }
                        add(DataPoint("Origin", state.data.origin.name))
                        add(DataPoint("Episodes count", state.data.episodeUrls.size.toString()))
                    }

                    is UiState.Error, UiState.Loading -> {}
                }
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.loadCharacter(1)
    }

    when (val state = uiState) {
        is UiState.Success -> {
            CharacterDetailsScreen(
                character = state.data,
                characterDataPoints = characterDataPoints,
                modifier = modifier
            )
        }

        is UiState.Error -> {}

        UiState.Loading -> {
            LoadingComponent()
        }
    }

}

@Composable
private fun CharacterDetailsScreen(
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

        item {
            SubcomposeAsyncImage(
                model = character.imageUrl,
                contentDescription = "Character image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(12.dp)),
                loading = { LoadingComponent() },
            )
        }

        items(characterDataPoints) {
            Spacer(modifier = Modifier.height(32.dp))
            DataPointComponent(dataPoint = it)
        }

        item { Spacer(modifier = Modifier.height(32.dp)) }
    }
}