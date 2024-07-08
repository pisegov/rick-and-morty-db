package com.myaxa.character_details.data.network

import com.myaxa.character_details.data.network.model.CharacterDTO
import com.myaxa.core.domain.CharacterId
import com.myaxa.network.NetworkClientProvider
import com.myaxa.network.NetworkService
import com.myaxa.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

fun CharacterDetailsNetworkDataSource(networkClientProvider: NetworkClientProvider): CharacterDetailsNetworkDataSource {
    return CharacterDetailsNetworkDataSource(networkClientProvider.client)
}

class CharacterDetailsNetworkDataSource internal constructor(
    private val client: HttpClient
) : NetworkService {

    internal suspend fun getCharacter(id: CharacterId): Result<CharacterDTO> = safeApiCall {
        client.get("character/$id").body()
    }
}