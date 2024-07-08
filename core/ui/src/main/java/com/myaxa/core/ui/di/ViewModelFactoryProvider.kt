package com.myaxa.core.ui.di

import androidx.lifecycle.ViewModelProvider

interface ViewModelFactoryProvider {
    fun provideViewModelFactory(): ViewModelProvider.Factory
}