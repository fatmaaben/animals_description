package com.example.animals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.animals.Model.AnimalListScreen
import com.example.animals.ui.theme.AnimalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalsAppTheme {
                AnimalListScreen()
            }
        }
    }
}
