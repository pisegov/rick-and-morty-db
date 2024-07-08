package com.myaxa.pcrm.di

import com.myaxa.character_details.di.CharacterDetailsApiModule
import com.myaxa.character_list.di.CharactersApiModule
import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        CharactersApiModule::class,
        CharacterDetailsApiModule::class,
    ]
)
internal interface ApplicationModule