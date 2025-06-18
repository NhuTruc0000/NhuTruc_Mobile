package com.example.uth_smart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth


@Composable
fun ProfileScreen() {
    val user = FirebaseAuth.getInstance().currentUser

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(model = user?.photoUrl, contentDescription = null, modifier = Modifier.size(100.dp).clip(CircleShape))
        Spacer(modifier = Modifier.height(16.dp))
        Text("Name: ${user?.displayName}")
        Text("Email: ${user?.email}")
        Text("Date of Birth: 23/05/1995") // có thể thêm giao diện chọn ngày
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            FirebaseAuth.getInstance().signOut()
        }) {
            Text("Logout")
        }
    }
}