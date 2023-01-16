package com.example.meudesafiopicpay

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    fun getAllUsers(): Call<List<Users>>

    companion object {
        private val retrofitService: RetrofitService by lazy{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService{
            return retrofitService
        }
    }
}