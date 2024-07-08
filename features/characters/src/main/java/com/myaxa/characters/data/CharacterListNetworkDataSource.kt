package com.myaxa.characters.data

import com.myaxa.characters.domain.CharacterId
import com.myaxa.network.NetworkClientProvider
import com.myaxa.network.NetworkService
import com.myaxa.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

fun CharacterListNetworkDataSource(networkClientProvider: NetworkClientProvider): CharacterListNetworkDataSource {
    return CharacterListNetworkDataSource(networkClientProvider.client)
}

class CharacterListNetworkDataSource internal constructor(
    private val client: HttpClient,
) : NetworkService {
    suspend fun getCharacter(id: CharacterId): Result<CharacterDTO> = safeApiCall {
        client.get("character/$id").body()
    }
}