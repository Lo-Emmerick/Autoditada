package com.example.autodidata.app

import android.app.Application
import com.example.autodidata.di.databaseModule
import com.example.autodidata.di.loadRepositories
import com.example.autodidata.di.loadUseCase
import com.example.autodidata.di.loadViewModel
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger()
            }
            androidContext(this@MyApp)
            modules(loadViewModel, loadUseCase, loadRepositories, databaseModule)
        }
    }
}