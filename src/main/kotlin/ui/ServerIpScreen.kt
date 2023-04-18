package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navigation.NavController
import navigation.Screen

@Composable
fun ServerIpScreen(navController: NavController) {
    var serverIp by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = serverIp,
            onValueChange = { serverIp = it },
            label = {
                Text("Adresse Ip du Serveur")
            }
        )

        Button(onClick = { navController.navigate(Screen.SignIn.name) }) {
            Text("Se connecter")
        }
    }
}