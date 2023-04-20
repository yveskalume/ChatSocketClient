package ui

import Client
import ServerConnectionListener
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import navigation.NavController
import navigation.Screen

@Composable
fun SignIn(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }

    val scaffoldState = rememberScaffoldState()

    val channel = Channel<String>(Channel.CONFLATED)

    var serverIp by remember { mutableStateOf("") }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    LaunchedEffect(channel) {
        channel.consumeAsFlow().collectLatest { message ->
            scaffoldState.snackbarHostState.showSnackbar(message = message)
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        Box(modifier = Modifier.fillMaxSize().padding(it)) {
            AnimatedVisibility(visible = isLoading, modifier = Modifier.align(Alignment.Center)) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            Column(
                modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.CenterVertically)
            ) {
                OutlinedTextField(
                    value = serverIp,
                    onValueChange = { serverIp = it },
                    label = {
                        Text("Adresse Ip du Serveur")
                    }
                )

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

                Button(
                    enabled = !isLoading,
                    onClick = {
                        isLoading = true
                        Client.connectToServer(
                            serverIp.trim(),
                            email.trim(),
                            object : ServerConnectionListener {
                                override fun onSuccess() {
                                    isLoading = false
                                    navController.navigate(Screen.Home.name)
                                }

                                override fun onError(throwable: Throwable?) {
                                    isLoading = false
                                    coroutineScope.launch {
                                        channel.send(throwable?.message ?: "Erreur")
                                    }
                                }
                            }
                        )
                    }
                ) {
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
    }
}