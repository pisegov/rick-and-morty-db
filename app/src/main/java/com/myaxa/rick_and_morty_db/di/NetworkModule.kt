package com.myaxa.rick_and_morty_db.di

import com.myaxa.character_data.data.network.CharacterNetworkDataSource
import com.myaxa.network.NetworkClientProvider
import com.myaxa.rick_and_morty_db.BuildConfig
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
    internal fun provideCharacterNetworkDataSource(
        networkClientProvider: NetworkClientProvider,
    ): CharacterNetworkDataSource {
        return CharacterNetworkDataSource(networkClientProvider)
    }
}
