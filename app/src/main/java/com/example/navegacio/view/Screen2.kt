package com.example.navegacio.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacio.Routes

/**
 * Definició de la pantalla 2
 * @param navController
 * @param nom
 * @author RIS
 * @since 2024-11-20
 */
@Composable
fun Screen2(navController: NavController, nom: String) {
    var salutacio: String by remember { mutableStateOf("Hola") }
    var edat: Float by remember { mutableStateOf(0f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RadioButton(
                selected = salutacio == "Hola",
                onClick = { salutacio = "Hola" }
            )
            Text("Hola")

            RadioButton(
                selected = salutacio == "Adéu",
                onClick = { salutacio = "Adéu" }
            )
            Text("Adéu")
        }

        Slider(
            value = edat,
            onValueChange = { edat = it },
            valueRange = 0f..100f,
            steps = 99,
            modifier = Modifier
                .fillMaxWidth(0.75f)
        )

        Text(text = edat.toString())

        Button(
            onClick = {
                navController.navigate(
                    Routes.Pantalla3.createRoute(
                        nom,
                        salutacio,
                        edat.toInt()
                    )
                )
            },
            enabled = if (salutacio.isNotEmpty() && salutacio.isNotEmpty()) true else false
        ) {
            Text("Següent pas")
        }
    }
}