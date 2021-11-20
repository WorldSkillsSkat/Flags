package com.example.task1.di

import com.example.task1.authorization.login.LoginViewModel
import com.example.task1.authorization.register.RegisterViewModel
import com.example.task1.data.NetworkService
import com.example.task1.flags.FlagsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { NetworkService() }

    viewModel { LoginViewModel(networkService = get()) }
    viewModel { RegisterViewModel(networkService = get()) }
    viewModel { FlagsViewModel(networkService = get()) }
}