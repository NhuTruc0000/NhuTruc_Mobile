package com.example.thuchanh01

// ✅ Import cho Compose UI và Navigation
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thuchanh01.ui.theme.Thuchanh01Theme

@Composable
fun MainScreen(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Navigation")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigate) {
            Text("PUSH")
        }
    }
}

@Composable
fun ListScreen(onItemClick: (String) -> Unit) {
    val quotes = List(5) { "The only way to do great work is to love what you do." }

    LazyColumn {
        itemsIndexed(quotes) { index, quote ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onItemClick(quote) }
            ) {
                Text("${index + 1} | $quote", modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowForward, contentDescription = "Next")
            }
        }
    }
}

@Composable
fun DetailScreen(quote: String, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = quote, style = MaterialTheme.typography.titleLarge
            , textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("BACK TO ROOT")
        }
    }
}
