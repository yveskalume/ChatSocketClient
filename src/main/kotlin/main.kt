import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.NavigationHost
import navigation.Screen
import navigation.composable
import navigation.rememberNavController
import ui.HomeScreen
import ui.SignIn
import ui.SignUp

@Composable
@Preview
fun App() {
    val navController by rememberNavController(Screen.SignIn.name)

    MaterialTheme {
        Surface {
            NavigationHost(navController) {

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
    Window(
        title = "TP Application Distribué",
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
