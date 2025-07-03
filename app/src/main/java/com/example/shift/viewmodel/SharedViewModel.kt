package com.example.shift.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift.UserEntity
import com.example.shift.data.repository.UserRepository
import com.example.shift.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SharedViewModel(
    private val repository: UserRepository
) : ViewModel() {
    
    private val _usersState = MutableStateFlow<Resource<List<UserEntity>>>(Resource.Loading())
    val usersState: StateFlow<Resource<List<UserEntity>>> = _usersState.asStateFlow()
    
    private val _selectedUser = MutableStateFlow<UserEntity?>(null)
    val selectedUser: StateFlow<UserEntity?> = _selectedUser.asStateFlow()
    
    init {
        loadUsersFromDb()
    }
    
    private fun loadUsersFromDb() {
        viewModelScope.launch {
            _usersState.value = Resource.Loading()
            val result = repository.loadUsersFromDb()
            _usersState.value = result
            
            // Если в базе нет данных, загружаем из сети
            if (result is Resource.Loading) {
                fetchUsers()
            }
        }
    }
    
    fun fetchUsers(count: Int = 10) {
        viewModelScope.launch {
            _usersState.value = Resource.Loading()
            val result = repository.fetchUsers(count)
            _usersState.value = result
        }
    }
    
    fun refreshUsers() {
        viewModelScope.launch {
            _usersState.value = Resource.Loading()
            val result = repository.refreshUsers()
            _usersState.value = result
        }
    }
    
    fun selectUser(user: UserEntity) {
        _selectedUser.value = user
    }
    
    fun clearSelectedUser() {
        _selectedUser.value = null
    }
} 
