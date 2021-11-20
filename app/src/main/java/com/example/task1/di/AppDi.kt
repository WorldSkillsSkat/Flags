package com.example.task1.di

import com.example.task1.authorization.AuthorizationViewModel
import com.example.task1.data.NetworkService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { NetworkService() }

    viewModel { AuthorizationViewModel(networkService = get()) }
}