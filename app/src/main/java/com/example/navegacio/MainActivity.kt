package com.example.navegacio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacio.ui.theme.NavegacioTheme
import com.example.navegacio.view.Screen1
import com.example.navegacio.view.Screen2
import com.example.navegacio.view.Screen3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacioTheme {
                
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ) {
                        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(
                            Routes.Pantalla2.route,
                            arguments = listOf(
                                navArgument("nom") { type = NavType.StringType },
                                navArgument("nom") {})
                        ) { backStackEntry ->
                            Screen2(
                                navigationController,
                                backStackEntry.arguments?.getString("nom").orEmpty()
                            )
                        }
                        composable(
                            Routes.Pantalla3.route,
                            arguments = listOf(
                                navArgument("nom") { type = NavType.StringType },
                                navArgument("salutacio") { type = NavType.StringType },
                                navArgument("edat") { type = NavType.IntType })
                            ) { backStackEntry ->
                                Screen3(
                                    navigationController,
                                    backStackEntry.arguments?.getString("nom").orEmpty(),
                                    backStackEntry.arguments?.getString("salutacio").orEmpty(),
                                    backStackEntry.arguments?.getInt("edat") ?: 0
                                )
                            }
                    }
                }
            }
        }
    }
}