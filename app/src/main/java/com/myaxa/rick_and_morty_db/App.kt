package com.myaxa.rick_and_morty_db

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.myaxa.core.ui.di.ViewModelFactoryProvider
import com.myaxa.rick_and_morty_db.di.ApplicationComponent
import com.myaxa.rick_and_morty_db.di.DaggerApplicationComponent

internal class App : Application(), ViewModelFactoryProvider {
    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create()
    }

    override fun provideViewModelFactory(): ViewModelProvider.Factory {
        return component.viewModelFactory
    }
}