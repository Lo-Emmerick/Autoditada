package com.example.autodidata.domain.usecase

class LoginUseCase (
    //private val repository: HomeRepository
) : LoginInterfaceUseCase {
    override suspend operator fun invoke(): TaskList {
        val updatedTasks = repository.searchTask()
        return updatedTasks.toTaskList()
    }
}