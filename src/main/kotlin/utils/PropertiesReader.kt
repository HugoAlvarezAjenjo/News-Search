package utils

import java.util.Properties

private const val API = "api.properties"

object PropertiesReader {
    private val properties = Properties()
    val API_KEY: String

    init {
        val file = this::class.java.classLoader.getResourceAsStream(API)
        // this.class.classLoader.getResourceAsStream(API)
        // properties.load(new FileInputStream(new File("configuracion.properties")))
        properties.load(file)
        this.API_KEY = getProperty("API_KEY")
    }

    fun getProperty(key: String): String = properties.getProperty(key)
}