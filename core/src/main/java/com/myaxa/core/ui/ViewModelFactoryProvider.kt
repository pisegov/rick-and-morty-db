package com.myaxa.core.ui

import androidx.lifecycle.ViewModelProvider

interface ViewModelFactoryProvider {
    fun provideViewModelFactory(): ViewModelProvider.Factory
}