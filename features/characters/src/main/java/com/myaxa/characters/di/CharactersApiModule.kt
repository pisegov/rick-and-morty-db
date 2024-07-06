package com.myaxa.characters.di

import androidx.lifecycle.ViewModel
import com.myaxa.characters.ui.CharactersViewModel
import com.myaxa.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CharactersApiModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    internal abstract fun bindCharactersViewModel(impl: CharactersViewModel): ViewModel
}