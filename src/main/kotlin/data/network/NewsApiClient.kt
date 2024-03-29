package data.network

import data.network.response.NewsResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import utils.PropertiesReader

object NewsApiClient {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getTopHeadlines(): NewsResponse {
        val url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=${PropertiesReader.API_KEY}"
        return client.get(url).body()
    }

    suspend fun getSearchedNews(searchedText: String): NewsResponse {
        val url = "https://newsapi.org/v2/everything?q=${searchedText}&apiKey=${PropertiesReader.API_KEY}"
        return client.get(url).body()
    }
}