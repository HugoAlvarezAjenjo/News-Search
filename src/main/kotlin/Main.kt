import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ui.MainScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "News",
        state = WindowState(width = 1000.dp, height = 700.dp),
        icon = painterResource("logo.png")
    ) {
        MainScreen()
    }
}
