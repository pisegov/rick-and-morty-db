package com.myaxa.characters.data

import com.myaxa.characters.domain.CharacterId
import com.myaxa.network.NetworkClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class CharactersNetworkDataSource @Inject constructor(networkClient: NetworkClient) {
    private val client = networkClient.client

    suspend fun getCharacter(id: CharacterId): CharacterDTO {
        return client.get("character/$id").body()
    }
}