package com.myaxa.characters.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun CharactersScreen(
    viewModel: CharactersViewModel,
    modifier: Modifier = Modifier,
) {
    val character = viewModel.characterFlow.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.loadCharacter(1)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .padding(120.dp)
    ) {
        character.value?.run {
            Text(text = id.toString())
            Text(text = name)
            Text(text = origin.name)
        }
    }
}