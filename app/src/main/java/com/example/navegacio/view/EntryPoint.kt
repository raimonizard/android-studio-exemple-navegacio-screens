package com.example.navegacio.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navegacio.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryPoint(navigationController: NavController) {
    NavHost(
        navController = navigationController as NavHostController,
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
                backStackEntry.arguments?.getString("name").orEmpty()
            )
        }
        composable(
            Routes.Pantalla3.route,
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("saludo") { type = NavType.StringType },
                navArgument("edad") { type = NavType.IntType })
        ) { backStackEntry ->
            Screen3(
                navigationController,
                backStackEntry.arguments?.getString("name").orEmpty(),
                backStackEntry.arguments?.getString("saludo").orEmpty(),
                backStackEntry.arguments?.getInt("edad") ?: 0
            )
        }
    }
}