package com.example.navegacio.view

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController

@Composable
fun Screen3(navController: NavController, nom: String, salutacio: String, edat: Int) {
    var mostrarMissatge by remember {
        mutableStateOf(false)
    }

    var missatge = ""

    if (salutacio == "Hola") {
        missatge = "Hola $nom, tens $edat anys"
    } else {
        missatge = "Adéu $nom, tens $edat anys"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Button(onClick = {
            mostrarMissatge = true
        }) {
            Text(text = "Mostrar")
        }
        if (mostrarMissatge) {
            Text(text = missatge)
        }
        Share(missatge)
    }
}

@Composable
fun Share(text: String) {
    val context = LocalContext.current
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }

    val shareIntent = Intent.createChooser(sendIntent, "Compartir amb...")

    Button(
        onClick = {
            ContextCompat.startActivity(context, shareIntent, null)
        }
    ) {
        Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
        Text(text = "Compartir", modifier = Modifier.padding(start = 8.dp))
    }
}