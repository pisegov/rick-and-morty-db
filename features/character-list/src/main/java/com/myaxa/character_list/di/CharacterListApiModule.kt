package com.myaxa.character_list.di

import androidx.lifecycle.ViewModel
import com.myaxa.character_list.ui.CharacterListViewModel
import com.myaxa.core.ui.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CharacterListApiModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    internal abstract fun bindCharacterListViewModel(impl: CharacterListViewModel): ViewModel
}