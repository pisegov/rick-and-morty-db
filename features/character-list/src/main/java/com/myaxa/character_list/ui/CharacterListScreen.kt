package com.myaxa.character_list.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.myaxa.core.ui.components.LoadingComponent
import com.myaxa.core.ui.di.daggerViewModel

@Composable
internal fun CharacterListScreen(
    viewModel: CharacterListViewModel = daggerViewModel(),
) {
    val uiState by viewModel.characterListFlow.collectAsState()

    LaunchedEffect(key1 = viewModel) { viewModel.loadInitialPage() }

    when (val state = uiState) {
        is UiState.Success -> {
            CharacterList(state.list)
        }

        is UiState.Error -> {}

        UiState.Loading -> {
            LoadingComponent()
        }
    }
}
