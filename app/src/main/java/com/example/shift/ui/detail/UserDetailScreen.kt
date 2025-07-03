package com.example.shift.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import android.net.Uri
import com.example.shift.UserEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    user: UserEntity,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Детали пользователя") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = user.photoUrl,
                contentDescription = "Фото пользователя",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = user.firstName + " " + user.lastName,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = user.email,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:${user.email}")
                    }
                    context.startActivity(intent)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = user.phone,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:${user.phone}")
                    }
                    context.startActivity(intent)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = user.address,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable {
                    val address = Uri.encode(user.address)
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$address"))
                    context.startActivity(intent)
                }
            )
        }
    }
} 