package com.myaxa.character_list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myaxa.character_list.ui.CharactersScreen
import com.myaxa.character_list.ui.CharactersViewModel
import com.myaxa.core_ui.di.daggerViewModel

const val CHARACTERS_SCREEN_ROUTE = "characters"

fun NavGraphBuilder.charactersScreenDestination() {
    composable(CHARACTERS_SCREEN_ROUTE) {

        val viewModel: CharactersViewModel = daggerViewModel()
        CharactersScreen(
            viewModel = viewModel,
        )
    }
}
