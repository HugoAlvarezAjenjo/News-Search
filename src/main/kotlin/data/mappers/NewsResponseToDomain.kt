package data.mappers

import data.network.response.ArticleResponse
import data.network.response.NewsResponse
import domain.model.Article
import domain.model.News

fun NewsResponse.toDomain(): News {
    val articleList = List<Article>(this.articles.size) {
        this.articles[it].toDomain()
    }
    return News(
        articles = articleList
    )
}

fun ArticleResponse.toDomain(): Article {
    return Article(
        title = this.title,
        content = this.content ?: "",
        url = url,
        urlToImage = urlToImage ?: ""
    )
}