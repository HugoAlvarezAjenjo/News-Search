package data

import data.mappers.toDomain
import data.network.NewsApiClient
import domain.Repository
import domain.model.News
import io.ktor.client.plugins.*

class RepositoryImplementation : Repository {
    override suspend fun getSearchedNews(search: String): News {
        assert(search.isNotEmpty())
        try {
            return NewsApiClient.getSearchedNews(search).toDomain()
        } catch (e: ClientRequestException) {
            println("Error fetching searchedNews: ${e.message}")
            return News(listOf())
        }
    }

    override suspend fun getTopHeadlines(): News {
        try {
            return NewsApiClient.getTopHeadlines().toDomain()
        } catch (e: ClientRequestException) {
            println("Error fetching topHeadlines: ${e.message}")
            return News(listOf())
        }
    }
}