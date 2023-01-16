package com.example.meudesafiopicpay

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel constructor(private val repository: UsersRepository) : ViewModel() {

    val userList = MutableLiveData<List<Users>>()
    val errorMessage = MutableLiveData<String>()



    fun liveDataReceivesData(): Boolean {
        val userList = userList
        return userList.value?.isNotEmpty() == true
    }



    fun getAllUsers(){

        viewModelScope.launch(Dispatchers.IO) {
            val request = repository.getAllUsers()

            request.enqueue(object : Callback<List<Users>>{
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                    userList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }}