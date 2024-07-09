package com.myaxa.rick_and_morty_db.di

import androidx.lifecycle.ViewModelProvider
import com.myaxa.rick_and_morty_db.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory
}
