package com.example.autodidata.presentation.ui.login

interface LoginState {
    object Success : LoginState
    object Loading : LoginState
    object Empty : LoginState
    object Error : LoginState
}