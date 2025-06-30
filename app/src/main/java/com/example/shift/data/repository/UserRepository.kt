package com.example.shift.data.repository

import com.example.shift.User
import com.example.shift.utils.Resource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

class UserRepository {
    suspend fun fetchUsers(count: Int = 10): Resource<List<User>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = ApiService.api.getUsers(count)
            Resource.Success(response.results)
        } catch (e: Exception) {
            Resource.Error("Ошибка загрузки данных: ${e.message}")
        }
    }
} 