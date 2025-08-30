package com.example.autodidata.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autodidata.data.model.Users
import com.example.autodidata.domain.model.Login
import com.example.autodidata.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState> = _state


    fun checkLogin(data: Login) {
        _state.value = LoginState.Loading
        viewModelScope.launch {
            try {
                val response = loginUseCase(data)
                _state.value = LoginState.Success(response)
            } catch (e: Exception) {
                _state.value = LoginState.Error
            }
        }
    }

    fun checkLogin(data: Login) {
        _state.value = LoginState.Loading
        viewModelScope.launch {
            try {
                val response: Users? = loginUseCase(data) // ou retorna Users?

                if (response != null) {
                    // converte Users para Login
                    val login = Login(
                        username = response.username,
                        token = response.token
                        // outros campos...
                    )
                    _state.value = LoginState.Success(login)
                } else {
                    _state.value = LoginState.Error("Usuário não encontrado")
                }

            } catch (e: Exception) {
                _state.value = LoginState.Error(e.message)
            }
        }
    }

}