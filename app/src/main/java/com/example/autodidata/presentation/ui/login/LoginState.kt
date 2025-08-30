package com.example.autodidata.presentation.ui.login

import com.example.autodidata.domain.model.Login

interface LoginState {
    data class Success(val login: Login) : LoginState
    object Loading : LoginState
    object Empty : LoginState
    object Error : LoginState
}