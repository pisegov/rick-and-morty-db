package com.myaxa.pcrm.navigaion

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.myaxa.character_details.navigation.characterDetailsScreenDestination
import com.myaxa.character_details.navigation.navigateToCharacterDetails
import com.myaxa.character_list.navigation.CharacterListScreenRoute
import com.myaxa.character_list.navigation.characterListScreenDestination

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = CharacterListScreenRoute,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        characterListScreenDestination(
            onCharacterClicked = { id ->
                navController.navigateToCharacterDetails(characterId = id)
            }
        )

        characterDetailsScreenDestination()
    }
}