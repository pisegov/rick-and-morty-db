package com.myaxa.character_list.di

import androidx.lifecycle.ViewModel
import com.myaxa.character_list.ui.CharactersViewModel
import com.myaxa.core.ui.di.ViewModelKey
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