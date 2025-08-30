package com.example.autodidata.domain.usecase

import com.example.autodidata.data.model.Users
import com.example.autodidata.domain.model.Login

interface LoginUseCase {
    suspend operator fun invoke(user: Login): Users?
}