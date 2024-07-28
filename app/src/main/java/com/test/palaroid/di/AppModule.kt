package com.test.palaroid.di

import com.test.palaroid.data.WorldHeritageRepositoryImpl
import com.test.palaroid.domain.WorldHeritageRepository
import com.test.palaroid.viewmodel.WorldHeritageListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {
    single<WorldHeritageRepository> { WorldHeritageRepositoryImpl() }
    viewModel { WorldHeritageListViewModel(get()) }
}