package domain

import domain.model.News

interface Repository {
    suspend fun getSearchedNews(search: String): News
    suspend fun getTopHeadlines(): News
}