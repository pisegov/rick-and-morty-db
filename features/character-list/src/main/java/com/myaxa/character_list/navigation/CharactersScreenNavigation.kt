package com.myaxa.character_list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myaxa.character_list.ui.CharacterListScreen

const val CHARACTERS_SCREEN_ROUTE = "characters"

fun NavGraphBuilder.charactersScreenDestination() {
    composable(CHARACTERS_SCREEN_ROUTE) {

        CharacterListScreen()
    }
}
