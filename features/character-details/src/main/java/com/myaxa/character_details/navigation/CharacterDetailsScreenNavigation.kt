package com.myaxa.character_details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myaxa.character_details.ui.CharacterDetailsScreen

const val CHARACTER_DETAILS_SCREEN_ROUTE = "character-details"

fun NavGraphBuilder.characterDetailsScreenDestination() {
    composable(CHARACTER_DETAILS_SCREEN_ROUTE) {
        CharacterDetailsScreen(characterId = 1)
    }
}
