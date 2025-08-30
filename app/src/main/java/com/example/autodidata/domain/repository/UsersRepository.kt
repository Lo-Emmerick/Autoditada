package com.example.autodidata.domain.repository

import com.example.autodidata.data.model.Users
import com.example.autodidata.domain.model.Login

interface UsersRepository {
    suspend fun searchLogin(user: Login) : Users?
    suspend fun addUser(user: Users) : Users
}