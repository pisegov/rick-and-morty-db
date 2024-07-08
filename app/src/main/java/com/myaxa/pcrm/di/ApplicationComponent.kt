package com.myaxa.pcrm.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import javax.inject.Scope

@ApplicationScope
@Component(modules = [ApplicationModule::class])
internal interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(): ApplicationComponent
    }

    val viewModelFactory: ViewModelProvider.Factory
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ApplicationScope