package com.example.shift.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift.User
import com.example.shift.data.repository.UserRepository
import com.example.shift.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SharedViewModel(
    private val repository: UserRepository
) : ViewModel() {
    
    private val _usersState = MutableStateFlow<Resource<List<User>>>(Resource.Loading())
    val usersState: StateFlow<Resource<List<User>>> = _usersState.asStateFlow()
    
    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser.asStateFlow()
    
    init {
        loadUsers()
    }
    
    fun loadUsers() {
        viewModelScope.launch {
            repository.getUsers().collect { resource ->
                _usersState.value = resource
            }
        }
    }
    
    fun refreshUsers() {
        viewModelScope.launch {
            _usersState.value = Resource.Loading()
            val result = repository.refreshUsers()
            _usersState.value = result
        }
    }
    
    fun selectUser(user: User) {
        _selectedUser.value = user
    }
    
    fun selectUserByEmail(email: String) {
        viewModelScope.launch {
            val user = repository.getUserByEmail(email)
            _selectedUser.value = user
        }
    }
    
    fun clearSelectedUser() {
        _selectedUser.value = null
    }
} 