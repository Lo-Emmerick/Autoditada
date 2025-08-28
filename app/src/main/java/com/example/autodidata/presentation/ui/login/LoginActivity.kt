package com.example.autodidata.presentation.ui.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.autodidata.databinding.LoginActivityBinding
import com.example.autodidata.domain.model.Login
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindObserver()
        bindListener()

    }

    private fun bindListener() {
        binding.login.setOnClickListener {
            val login = Login(
                email = binding.inputEmail.text.toString(),
                password = binding.inputPassword.text.toString()
            )
            viewModel.checkLogin(login)
        }
    }

    private fun bindObserver() {}
}