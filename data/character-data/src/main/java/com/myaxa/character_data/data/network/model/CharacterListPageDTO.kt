package com.myaxa.character_data.data.network.model

import com.myaxa.character_data.domain.CharacterListPageInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharacterListPageDTO(
    @SerialName("info") val info: InfoDTO,
    @SerialName("results") val list: List<CharacterDTO>
) {

    @Serializable
    internal data class InfoDTO(
        @SerialName("count") val count: Int,
        @SerialName("pages") val pages: Int,
    )
}

internal fun CharacterListPageDTO.toDomainModel() = CharacterListPageInfo(
    list = list.map { it.toDomainModel() },
    totalPagesNumber = info.pages
)