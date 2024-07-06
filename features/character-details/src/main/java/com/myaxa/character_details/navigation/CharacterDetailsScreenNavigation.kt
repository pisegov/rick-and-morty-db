package com.myaxa.character_details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myaxa.character_details.ui.CharacterDetailsScreen
import com.myaxa.character_details.ui.CharacterDetailsViewModel
import com.myaxa.core.ui.daggerViewModel

const val CHARACTER_DETAILS_SCREEN_ROUTE = "character-details"

fun NavGraphBuilder.characterDetailsScreenDestination() {
    composable(CHARACTER_DETAILS_SCREEN_ROUTE) {
        val viewModel: CharacterDetailsViewModel = daggerViewModel()
        CharacterDetailsScreen(
            viewModel = viewModel,
        )
    }
}
