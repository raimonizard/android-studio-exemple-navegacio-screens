package com.example.navegacio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.navegacio.ui.theme.NavegacioTheme
import com.example.navegacio.view.EntryPoint


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Definim el controlador de navegació
                    val navigationController = rememberNavController()
                    // Crida a la vista EntryPoint i passa el controlador de navegació
                    EntryPoint(navigationController)
                }
            }
        }
    }
}