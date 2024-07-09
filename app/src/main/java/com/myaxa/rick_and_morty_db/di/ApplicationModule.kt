package com.myaxa.rick_and_morty_db.di

import com.myaxa.character_details.di.CharacterDetailsApiModule
import com.myaxa.character_list.di.CharacterListApiModule
import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        CharacterListApiModule::class,
        CharacterDetailsApiModule::class,
    ]
)
internal interface ApplicationModule