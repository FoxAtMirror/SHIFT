package com.example.shift.data.repository

import com.example.shift.User
import com.example.shift.utils.Resource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.shift.UserEntity
import com.example.shift.toEntity
import com.example.shift.toUser
import com.example.shift.data.db.UserDao

// Retrofit API
interface RandomUserApi {
    @GET("api/")
    suspend fun getUsers(@Query("results") count: Int = 10): com.example.shift.UserResponse
}

object ApiService {
    val api: RandomUserApi = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RandomUserApi::class.java)
}

class UserRepository(
    private val api: RandomUserApi,
    private val userDao: UserDao
) {
    suspend fun fetchUsersFromApi(count: Int = 10): List<User> {
        return api.getUsers(count).results
    }

    suspend fun saveUsersToDb(users: List<UserEntity>) {
        userDao.clearAll()
        userDao.insertAll(users)
    }

    suspend fun getUsersFromDb(): List<UserEntity> {
        return userDao.getAll()
    }

    suspend fun syncUsers(count: Int = 10) {
        val usersFromApi = fetchUsersFromApi(count)
        val entities = usersFromApi.map { it.toEntity() }
        saveUsersToDb(entities)
    }
    
    suspend fun fetchUsers(count: Int = 10): Resource<List<UserEntity>> {
        return try {
            val users = fetchUsersFromApi(count)
            val entities = users.map { it.toEntity() }
            saveUsersToDb(entities)
            Resource.Success(entities)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Произошла ошибка при загрузке пользователей")
        }
    }
    
    suspend fun loadUsersFromDb(): Resource<List<UserEntity>> {
        return try {
            val users = getUsersFromDb()
            if (users.isNotEmpty()) {
                Resource.Success(users)
            } else {
                Resource.Loading()
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Ошибка загрузки из базы данных")
        }
    }
    
    suspend fun refreshUsers(count: Int = 10): Resource<List<UserEntity>> {
        return try {
            val users = fetchUsersFromApi(count)
            val entities = users.map { it.toEntity() }
            saveUsersToDb(entities)
            Resource.Success(entities)
        } catch (e: Exception) {
            // Если сеть недоступна, загружаем из базы
            loadUsersFromDb()
        }
    }
} 