package com.example.autodidata.data.repository

import com.example.autodidata.data.local.dao.UsersDao
import com.example.autodidata.data.model.Users
import com.example.autodidata.domain.model.Login
import com.example.autodidata.domain.repository.UsersRepository

class UsersRepositoryImpl(
    private val dao: UsersDao
) : UsersRepository {
    override suspend fun searchLogin(user: Login): Users? {
        return dao.getUser(user.email, user.password)
    }

    override suspend fun addUser(user: Users): Users{
        dao.insertUser(user)
        return user
    }

}