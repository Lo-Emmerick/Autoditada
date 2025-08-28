package com.example.autodidata.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
                _state.value = LoginState.Success
            } catch (e: Exception) {
                _state.value = LoginState.Error
            }
        }
    }}