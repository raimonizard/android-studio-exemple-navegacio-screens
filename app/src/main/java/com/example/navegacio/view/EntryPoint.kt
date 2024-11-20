package com.example.navegacio.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navegacio.Routes

/**
 * Definim el composable NavHost que el cridarem des del Main
 * @param navigationController
 * @author RIS
 * @since 2024-11-20
 */
@Composable
fun EntryPoint(navigationController: NavController) {
    // Definim el component NavHost per a establir les rutes entre pantalles
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.Pantalla1.route
    ) {

        // Establim que la ruta Pantalla1 ens dirigeix cap a la vista composable Screen1
        composable(Routes.Pantalla1.route) { Screen1(navigationController) }

        // Establim que la ruta Pantalla2 ens dirigeix cap a la vista composable Screen2
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

        // Establim que la ruta Pantalla3 ens dirigeix cap a la vista composable Screen3
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