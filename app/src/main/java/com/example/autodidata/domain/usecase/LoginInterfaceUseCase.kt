package com.example.autodidata.domain.usecase

interface LoginInterfaceUseCase {
    suspend operator fun invoke(): TaskList
}