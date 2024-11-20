package com.example.navegacio

sealed class Routes(val route: String) {
    object Pantalla1 : Routes("pantalla1")

    object Pantalla2 : Routes("pantalla2/{nom}") {
        fun createRoute(nom: String) = "pantalla2/$nom"
    }

    object Pantalla3 : Routes("pantalla3/{nom}/{salutacio}/{edat}") {
        fun createRoute(nom: String, salutacio: String, edat: Int) = "pantalla3/$nom/$salutacio/$edat"
    }
}