package com.myaxa.core.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myaxa.core.ui.theme.RickAction

private val defaultModifier: Modifier = Modifier.fillMaxSize().padding(128.dp)

@SuppressLint("ModifierParameter")
@Composable
fun LoadingComponent(modifier: Modifier = defaultModifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = RickAction
    )
}