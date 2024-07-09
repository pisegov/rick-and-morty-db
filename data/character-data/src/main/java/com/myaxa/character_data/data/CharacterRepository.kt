package com.myaxa.character_data.data

import com.myaxa.character_data.data.network.CharacterNetworkDataSource
import com.myaxa.character_data.data.network.model.toDomainModel
import com.myaxa.character_data.domain.Character
import com.myaxa.character_data.domain.CharacterListPageInfo
import com.myaxa.core.domain.CharacterId
import jakarta.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterNetworkDataSource,
) {

    suspend fun loadCharacterListPage(pageNumber: Int): Result<CharacterListPageInfo> {
        return remoteDataSource.getCharacterListPage(pageNumber).map { it.toDomainModel() }
    }

    suspend fun getCharacter(id: CharacterId): Result<Character> {
        return remoteDataSource.getCharacter(id).map { it.toDomainModel() }
    }
}