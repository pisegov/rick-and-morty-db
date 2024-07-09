package com.myaxa.character_list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myaxa.character_list.ui.CharacterListScreen
import com.myaxa.core.domain.CharacterId
import kotlinx.serialization.Serializable

@Serializable
object CharacterListScreenRoute

fun NavGraphBuilder.characterListScreenDestination(
    onCharacterClicked: (CharacterId) -> Unit,
) {
    composable<CharacterListScreenRoute> {

        CharacterListScreen(onCharacterClicked = onCharacterClicked)
    }
}
