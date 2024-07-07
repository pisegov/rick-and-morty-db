package com.myaxa.character_details.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.myaxa.character_details.ui.model.DataPoint
import com.myaxa.core.ui.theme.RickAction
import com.myaxa.core.ui.theme.RickTextPrimary

@Composable
internal fun DataPointComponent(
    dataPoint: DataPoint,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = dataPoint.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = RickAction
        )
        Text(
            text = dataPoint.description,
            fontSize = 24.sp,
            color = RickTextPrimary,
        )
    }
}

@Preview
@Composable
private fun DataPointComponentPreview() {
    DataPointComponent(dataPoint = DataPoint("Gender", "Male"))
}