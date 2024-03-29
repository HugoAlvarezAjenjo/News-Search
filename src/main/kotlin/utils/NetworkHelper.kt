package utils

import java.awt.Desktop
import java.net.URI

fun openURL(uri: URI) {
    val desktop = Desktop.getDesktop()
    desktop.browse(uri)
}