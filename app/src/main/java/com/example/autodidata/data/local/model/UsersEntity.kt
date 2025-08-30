package com.example.autodidata.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    indices = [Index(value = ["email"], unique = true)]
)
class UsersEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "checkEmail")
    val checkEmail: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "checkPassword")
    val checkPassword: String,
)