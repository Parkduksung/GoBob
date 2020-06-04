package com.work.gobob.viewmodel.di

import com.work.gobob.viewmodel.SearchViewModel
import com.work.gobob.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}