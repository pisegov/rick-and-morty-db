package com.myaxa.pcrm.di

import androidx.lifecycle.ViewModelProvider
import com.myaxa.pcrm.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory
}
