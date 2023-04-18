package navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


enum class Screen(
    val label: String,
) {
    Home(
        label = "Notifications",
    ),

    SignIn(
        label = "Se connecter",
    ),

    SignUp(
        label = "S'enregister",
    ),
}