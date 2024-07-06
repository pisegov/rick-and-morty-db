package com.myaxa.character_details.data.network

import com.myaxa.character_details.data.network.model.CharacterDTO
import com.myaxa.core.domain.CharacterId
import com.myaxa.network.NetworkClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class CharacterDetailsNetworkDataSource @Inject constructor(networkClient: NetworkClient) {
    private val client = networkClient.client

    internal suspend fun getCharacter(id: CharacterId): CharacterDTO = withContext(Dispatchers.IO) {
        client.get("character/$id").body()
    }
}