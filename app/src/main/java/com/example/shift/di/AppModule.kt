package com.example.shift.di

import android.content.Context
import androidx.room.Room
import com.example.shift.data.db.AppDatabase
import com.example.shift.data.repository.ApiService
import com.example.shift.data.repository.UserRepository

object AppModule {
    
    fun provideUserRepository(context: Context): UserRepository {
        val db = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "shift-db"
        ).build()
        return UserRepository(ApiService.api, db.userDao())
    }
} 