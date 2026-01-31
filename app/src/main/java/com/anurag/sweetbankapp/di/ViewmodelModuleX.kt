package com.anurag.sweetbankapp.di

import com.anurag.ui.DashboardViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        DashboardViewModel(get(), get(), get())
    }
}
