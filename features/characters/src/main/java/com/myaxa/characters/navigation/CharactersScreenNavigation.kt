package com.myaxa.characters.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myaxa.characters.ui.CharactersScreen
import com.myaxa.characters.ui.CharactersViewModel
import com.myaxa.core.ui.daggerViewModel

const val CHARACTERS_SCREEN_ROUTE = "characters"

fun NavGraphBuilder.charactersScreenDestination() {
    composable(CHARACTERS_SCREEN_ROUTE) {

        val viewModel: CharactersViewModel = daggerViewModel()
        CharactersScreen(
            viewModel = viewModel,
        )
    }
}
