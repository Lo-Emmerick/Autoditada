package com.example.autodidata.di

import androidx.room.Room
import com.example.autodidata.data.local.database.AppDatabase
import com.example.autodidata.data.repository.UsersRepositoryImpl
import com.example.autodidata.domain.repository.UsersRepository
import com.example.autodidata.domain.usecase.LoginUseCase
import com.example.autodidata.domain.usecase.LoginUseCaseImpl
import com.example.autodidata.presentation.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loadRepositories = module {
    single { UsersRepositoryImpl(dao = get()) as UsersRepository }
}
val loadUseCase = module {
    single<LoginUseCase> { LoginUseCaseImpl(repository = get()) }
}
val loadViewModel = module {
    viewModel<LoginViewModel> {
        LoginViewModel(
            loginUseCase = get<LoginUseCase>()
        )
    }
}
val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "task"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().usersDao() }
}