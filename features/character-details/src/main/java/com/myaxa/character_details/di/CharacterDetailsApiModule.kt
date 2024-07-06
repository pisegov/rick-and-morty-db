package com.myaxa.character_details.di

import androidx.lifecycle.ViewModel
import com.myaxa.character_details.ui.CharacterDetailsViewModel
import com.myaxa.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CharacterDetailsApiModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    internal abstract fun bindCharacterDetailsViewModel(impl: CharacterDetailsViewModel): ViewModel
}