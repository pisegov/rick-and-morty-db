package com.myaxa.pcrm.di

import androidx.lifecycle.ViewModelProvider
import com.myaxa.character_details.di.CharacterDetailsApiModule
import com.myaxa.characters.di.CharactersApiModule
import dagger.Component
import javax.inject.Scope

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class,
        CharactersApiModule::class,
        CharacterDetailsApiModule::class,
    ]
)
internal interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(): ApplicationComponent
    }

    val viewModelFactory: ViewModelProvider.Factory
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope