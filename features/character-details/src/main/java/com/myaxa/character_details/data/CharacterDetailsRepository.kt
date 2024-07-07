package com.myaxa.character_details.data

import com.myaxa.character_details.data.network.CharacterDetailsNetworkDataSource
import com.myaxa.character_details.data.network.model.toDomainModel
import com.myaxa.character_details.domain.Character
import com.myaxa.core.domain.CharacterId
import javax.inject.Inject

internal class CharacterDetailsRepository @Inject constructor(
    private val remoteDataSource: CharacterDetailsNetworkDataSource,
) {

    suspend fun getCharacter(id: CharacterId): Result<Character> {
       return remoteDataSource.getCharacter(id).map { it.toDomainModel() }
    }
}