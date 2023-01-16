package com.example.meudesafiopicpay.di

import com.example.meudesafiopicpay.RetrofitService
import com.example.meudesafiopicpay.UsersRepository
import com.example.meudesafiopicpay.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val retrofitService = RetrofitService.getInstance()

val mainModule = module {
    viewModel {
        UsersViewModel(UsersRepository(retrofitService))
    }
}