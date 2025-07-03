package com.example.shift.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shift.di.AppModule
import com.example.shift.ui.detail.UserDetailScreen
import com.example.shift.ui.users.UserListScreen
import com.example.shift.viewmodel.SharedViewModel
import com.example.shift.viewmodel.SharedViewModelFactory
import androidx.compose.ui.platform.LocalContext
import com.example.shift.UserEntity

sealed class Screen(val route: String) {
    object UserList : Screen("user_list")
    object UserDetail : Screen("user_detail")
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val sharedViewModel: SharedViewModel = viewModel(
        factory = SharedViewModelFactory(AppModule.provideUserRepository(context))
    )
    
    NavHost(
        navController = navController,
        startDestination = Screen.UserList.route
    ) {
        composable(Screen.UserList.route) {
            UserListScreen(
                onUserClick = { user ->
                    sharedViewModel.selectUser(user)
                    navController.navigate(Screen.UserDetail.route)
                },
                sharedViewModel = sharedViewModel
            )
        }
        
        composable(Screen.UserDetail.route) {
            val selectedUser by sharedViewModel.selectedUser.collectAsState()
            
            selectedUser?.let { user ->
                UserDetailScreen(
                    user = user,
                    onBackClick = { 
                        sharedViewModel.clearSelectedUser()
                        navController.popBackStack() 
                    }
                )
            }
        }
    }
} 