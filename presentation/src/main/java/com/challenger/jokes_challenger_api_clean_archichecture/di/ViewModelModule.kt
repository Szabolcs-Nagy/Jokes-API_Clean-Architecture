package com.challenger.jokes_challenger_api_clean_archichecture.di

import com.challenger.jokes_challenger_api_clean_archichecture.viewmodels.JokesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewmodelsModule = module {
    viewModel {
        JokesViewModel(
            get()
        )
    }
}