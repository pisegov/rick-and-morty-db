package com.myaxa.character_details.data.network

import com.myaxa.character_details.data.network.model.CharacterDTO
import com.myaxa.core.domain.CharacterId
import com.myaxa.network.NetworkClient
import com.myaxa.network.NetworkDataSource
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

internal class CharacterDetailsNetworkDataSource @Inject constructor(
    networkClient: NetworkClient
) : NetworkDataSource() {
    private val client = networkClient.client

    internal suspend fun getCharacter(id: CharacterId): Result<CharacterDTO> = safeApiCall {
        client.get("character/$id").body()
    }
}