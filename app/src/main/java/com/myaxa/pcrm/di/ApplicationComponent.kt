package com.myaxa.pcrm.di

import androidx.lifecycle.ViewModelProvider
import com.myaxa.network.NetworkClient
import com.myaxa.pcrm.BuildConfig
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import javax.inject.Scope

@ApplicationScope
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
internal interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(): ApplicationComponent
    }

    val viewModelFactory: ViewModelProvider.Factory
}

@Module
internal interface ApplicationModule {
    companion object {
        @Provides
        fun provideNetworkClient(): NetworkClient {
            val json = Json { ignoreUnknownKeys = true }
            return NetworkClient(BuildConfig.BASE_URL, json)
        }
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope