package com.example.autodidata.domain.usecase

import com.example.autodidata.data.model.Users
import com.example.autodidata.domain.model.Login
import com.example.autodidata.domain.repository.UsersRepository

class LoginUseCaseImpl (
    private val repository: UsersRepository
) : LoginUseCase {
    override suspend operator fun invoke(login: Login): Users? {
        val user = repository.searchLogin(login)
        return user
    }
}