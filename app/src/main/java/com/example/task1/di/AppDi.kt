package com.example.task1.di

import com.example.task1.authorization.AuthorizationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AuthorizationViewModel() }
}