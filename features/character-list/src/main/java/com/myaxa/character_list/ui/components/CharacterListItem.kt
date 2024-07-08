package com.myaxa.character_list.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myaxa.character_list.ui.model.CharacterUi
import com.myaxa.core.ui.components.CharacterImage
import com.myaxa.core.ui.theme.RickAction

@Composable
internal fun CharacterListItem(character: CharacterUi, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .border(
                width = 1.dp,
                brush = Brush.verticalGradient(listOf(Color.Transparent, RickAction)),
                shape = RoundedCornerShape(12.dp),
            )
    ) {
        Box {
            CharacterImage(
                imageUrl = character.imageUrl,
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(12.dp)),
            )
            CharacterStatusIcon(character.status, Modifier.padding(12.dp))
        }
        Text(
            text = character.name,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = RickAction,
            modifier = Modifier.padding(8.dp)
        )
    }
}