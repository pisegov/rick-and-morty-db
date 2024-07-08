package com.myaxa.character_data.data.network

import com.myaxa.character_data.data.network.model.CharacterDTO
import com.myaxa.character_data.data.network.model.CharacterListPageDTO
import com.myaxa.core.domain.CharacterId
import com.myaxa.network.NetworkClientProvider
import com.myaxa.network.NetworkService
import com.myaxa.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

fun CharacterNetworkDataSource(networkClientProvider: NetworkClientProvider): CharacterNetworkDataSource {
    return CharacterNetworkDataSource(networkClientProvider.client)
}

class CharacterNetworkDataSource internal constructor(
    private val client: HttpClient
) : NetworkService {

    internal suspend fun getCharacterListPage(
        pageNumber: Number
    ): Result<List<CharacterDTO>> = safeApiCall {
        client.get("character?page=$pageNumber").body<CharacterListPageDTO>().list
    }

    internal suspend fun getCharacter(id: CharacterId): Result<CharacterDTO> = safeApiCall {
        client.get("character/$id").body()
    }
}