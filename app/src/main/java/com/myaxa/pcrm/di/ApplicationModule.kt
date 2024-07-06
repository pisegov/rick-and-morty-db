package com.myaxa.pcrm.di

import androidx.lifecycle.ViewModelProvider
import com.myaxa.network.NetworkClient
import com.myaxa.pcrm.BuildConfig
import com.myaxa.pcrm.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json

@Module
internal interface ApplicationModule {

    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

    companion object {
        @Provides
        fun provideNetworkClient(): NetworkClient {
            val json = Json { ignoreUnknownKeys = true }
            return NetworkClient(BuildConfig.BASE_URL, json)
        }
    }
}