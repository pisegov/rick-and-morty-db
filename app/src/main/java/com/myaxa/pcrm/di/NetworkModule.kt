package com.myaxa.pcrm.di

import com.myaxa.character_details.data.network.CharacterDetailsNetworkDataSource
import com.myaxa.characters.data.CharacterListNetworkDataSource
import com.myaxa.network.NetworkClientProvider
import com.myaxa.pcrm.BuildConfig
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json

@Module
internal class NetworkModule {

    @Provides
    fun provideNetworkModule(): NetworkClientProvider {
        val json = Json { ignoreUnknownKeys = true }
        return NetworkClientProvider(BuildConfig.BASE_URL, json)
    }

    @Provides
    internal fun provideCharacterNetworkDataSource(networkClientProvider: NetworkClientProvider): CharacterListNetworkDataSource {
        return CharacterListNetworkDataSource(networkClientProvider)
    }

    @Provides
    internal fun provideCharacterDetailsNetworkDataSource(networkClientProvider: NetworkClientProvider): CharacterDetailsNetworkDataSource {
        return CharacterDetailsNetworkDataSource(networkClientProvider)
    }
}
