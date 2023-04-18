import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.NavigationHost
import navigation.Screen
import navigation.composable
import navigation.rememberNavController
import ui.HomeScreen
import ui.ServerIpScreen
import ui.SignIn
import ui.SignUp

@Composable
@Preview
fun App() {
    val navController by rememberNavController(Screen.ServerIP.name)

    MaterialTheme {
        Surface {
            NavigationHost(navController) {
                composable(Screen.ServerIP.name) {
                    ServerIpScreen(navController)
                }

                composable(Screen.Home.name) {
                    HomeScreen(navController)
                }

                composable(Screen.SignIn.name) {
                    SignIn(navController)
                }

                composable(Screen.SignUp.name) {
                    SignUp(navController)
                }

            }.build()
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
