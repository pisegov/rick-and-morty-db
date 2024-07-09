package com.myaxa.core.ui.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 *
 * Need to annotate @Binds annotated methods that bind viewModel instances into map
 * for [multi viewModel factory][com.myaxa.rick_and_morty_db.util.ViewModelFactory]
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)