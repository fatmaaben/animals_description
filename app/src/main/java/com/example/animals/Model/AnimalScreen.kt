package com.example.animals.Model

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

@Composable
fun AnimalListScreen() {
    var animals by remember { mutableStateOf(listOf<Animal>()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        try {
            isLoading = true
            animals = listOf(
                Animal("1", "Dog", "https://example.com/dog.jpg"),
                Animal("2", "Cat", "https://example.com/cat.jpg")
            ) // Ici remplacez par un appel à l'API
            isLoading = false
        } catch (e: Exception) {
            errorMessage = "Failed to load animals."
            isLoading = false
        }
    }

    if (isLoading) {
        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
    } else if (errorMessage.isNotEmpty()) {
        Text(text = errorMessage, modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(animals) { animal ->
                AnimalItem(animal = animal)
            }
        }
    }
}
