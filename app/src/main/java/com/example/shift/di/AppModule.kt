package com.example.shift.di

import com.example.shift.data.repository.UserRepository

object AppModule {
    
    fun provideUserRepository(): UserRepository {
        return UserRepository()
    }
} 