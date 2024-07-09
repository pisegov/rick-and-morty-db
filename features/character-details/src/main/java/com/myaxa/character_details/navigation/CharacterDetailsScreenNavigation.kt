package com.myaxa.character_details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.myaxa.character_details.ui.CharacterDetailsScreen
import com.myaxa.core.domain.CharacterId
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetailsScreenRoute(val characterId: CharacterId)

fun NavGraphBuilder.characterDetailsScreenDestination() {
    composable<CharacterDetailsScreenRoute> { navBackstackEntry ->

        val arguments: CharacterDetailsScreenRoute = navBackstackEntry.toRoute()

        CharacterDetailsScreen(characterId = arguments.characterId)
    }
}

fun NavController.navigateToCharacterDetails(characterId: CharacterId) {
    navigate(route = CharacterDetailsScreenRoute(characterId = characterId))
}