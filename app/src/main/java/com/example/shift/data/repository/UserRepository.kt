package com.example.shift.data.repository

import com.example.shift.User
import com.example.shift.data.MockData
import com.example.shift.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository {
    
    fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading())
        
        // Имитируем задержку загрузки
        delay(1000)
        
        try {
            val users = MockData.users
            emit(Resource.Success(users))
        } catch (e: Exception) {
            emit(Resource.Error("Ошибка загрузки данных: ${e.message}"))
        }
    }
    
    suspend fun refreshUsers(): Resource<List<User>> {
        return try {
            // Имитируем задержку обновления
            delay(800)
            Resource.Success(MockData.users)
        } catch (e: Exception) {
            Resource.Error("Ошибка обновления данных: ${e.message}")
        }
    }
    
    suspend fun getUserByEmail(email: String): User? {
        return MockData.users.find { it.email == email }
    }
} 