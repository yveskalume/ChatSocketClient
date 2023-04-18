package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import navigation.NavController
import navigation.Screen

@Composable
fun SignIn(navController: NavController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.CenterVertically)
    ) {

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text("Adresse email")
            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text("Mot de passe")
            }
        )

        Button(onClick = { navController.navigate(Screen.Home.name) }) {
            Text("Se connecter")
        }

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = buildAnnotatedString {
                append("Vous n'avez pas de compte ? ")
                withStyle(TextStyle(color = MaterialTheme.colors.primary).toSpanStyle()) {
                    append("S'inscrire")
                }
            },
            modifier = Modifier.clickable { navController.navigate(Screen.SignUp.name) }
        )
    }
}