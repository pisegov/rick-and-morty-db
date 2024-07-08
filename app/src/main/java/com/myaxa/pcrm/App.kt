package com.myaxa.pcrm

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.myaxa.core.ui.di.ViewModelFactoryProvider
import com.myaxa.pcrm.di.ApplicationComponent
import com.myaxa.pcrm.di.DaggerApplicationComponent

internal class App : Application(), ViewModelFactoryProvider {
    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create()
    }

    override fun provideViewModelFactory(): ViewModelProvider.Factory {
        return component.viewModelFactory
    }
}