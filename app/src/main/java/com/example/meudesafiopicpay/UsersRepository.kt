package com.example.meudesafiopicpay

class UsersRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllUsers() = retrofitService.getAllUsers()
}