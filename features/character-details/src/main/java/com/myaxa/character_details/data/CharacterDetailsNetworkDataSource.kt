package com.myaxa.character_details.data

import com.myaxa.core.domain.CharacterId
import com.myaxa.network.NetworkClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class CharacterDetailsNetworkDataSource @Inject constructor(networkClient: NetworkClient) {
    private val client = networkClient.client

    internal suspend fun getCharacter(id: CharacterId): CharacterDTO {
        return client.get("character/$id").body()
    }
}