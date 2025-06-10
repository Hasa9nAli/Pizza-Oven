package org.hasan.project.di

import com.hasan.test.viewModel.PizzaOvenViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PizzaOvenViewModel() }
}