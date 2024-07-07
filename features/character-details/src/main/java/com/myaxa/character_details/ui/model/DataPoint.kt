package com.myaxa.character_details.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

internal interface DataPoint {
    val title: String
    val description: String
        @Composable get
}

private class RawDataPoint(
    override val title: String,
    val descriptionString: String,
) : DataPoint {

    override val description @Composable get() = descriptionString
}

private class ResourceDataPoint(
    override val title: String,
    val descriptionResourceId: Int,
) : DataPoint {

    override val description @Composable get() = stringResource(id = descriptionResourceId)
}

internal fun DataPoint(title: String, descriptionString: String): DataPoint =
    RawDataPoint(title, descriptionString)

internal fun DataPoint(title: String, descriptionResourceId: Int): DataPoint =
    ResourceDataPoint(title, descriptionResourceId)


