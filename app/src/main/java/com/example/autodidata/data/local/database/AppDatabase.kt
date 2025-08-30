package com.example.autodidata.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.autodidata.data.local.dao.UsersDao
import com.example.autodidata.data.local.model.UsersEntity

@Database(entities = [UsersEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}