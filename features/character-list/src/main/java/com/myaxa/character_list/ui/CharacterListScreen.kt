package com.myaxa.character_list.ui

import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.myaxa.character_list.ui.model.UiState
import com.myaxa.core.domain.CharacterId
import com.myaxa.core.ui.components.LoadingComponent
import com.myaxa.core.ui.di.daggerViewModel

@Composable
internal fun CharacterListScreen(
    viewModel: CharacterListViewModel = daggerViewModel(),
    onCharacterClicked: (CharacterId) -> Unit = {},
) {
    val uiState by viewModel.characterListFlow.collectAsState()

    LaunchedEffect(key1 = viewModel) { viewModel.loadInitialPage() }

    val lazyStaggeredGridState = rememberLazyStaggeredGridState()
    val needToLoadNewPage by remember {
        derivedStateOf {
            val state = (uiState as? UiState.Success) ?: return@derivedStateOf false

            val currentCharactersCount = state.list.size
            val lastDisplayedItemIndex =
                lazyStaggeredGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                    ?: return@derivedStateOf false

            state.pageNumber != state.totalPagesNumber &&
                    lastDisplayedItemIndex >= currentCharactersCount - 10
        }
    }

    LaunchedEffect(key1 = needToLoadNewPage) {
        val pageNumber = (uiState as? UiState.Success)?.pageNumber ?: return@LaunchedEffect

        if (needToLoadNewPage) viewModel.loadNextPage(pageNumber)
    }

    when (val state = uiState) {
        is UiState.Success -> {
            CharacterList(
                characterList = state.list,
                lazyStaggeredGridState = lazyStaggeredGridState,
                onCharacterClicked = onCharacterClicked
            )
        }

        is UiState.Error -> {}

        UiState.Loading -> {
            LoadingComponent()
        }
    }
}
