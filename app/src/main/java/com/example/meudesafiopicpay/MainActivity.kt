package com.example.meudesafiopicpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meudesafiopicpay.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter = UsersAdapter()
    private val viewModel: UsersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
    }

    override fun onStart(){
        super.onStart()

        viewModel.userList.observe(this) { users ->
            adapter.setUserList(users)
            viewModel.liveDataReceivesData()
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, "falhou", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllUsers()
    }
}