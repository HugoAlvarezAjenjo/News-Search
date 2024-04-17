package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import data.RepositoryImplementation
import domain.Repository
import domain.model.Article
import kotlinx.coroutines.launch

@Preview
@Composable
fun MainScreen() {
    val repository: Repository = RepositoryImplementation()
    var articles by remember { mutableStateOf(emptyList<Article>()) }
    var headerTitle by remember { mutableStateOf("Headlines") }
    var searchedText by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    LaunchedEffect(searchedText) {
        scope.launch {
            val newsData = if (searchedText.isNotEmpty()) {
                repository.getSearchedNews(searchedText)
            } else {
                repository.getTopHeadlines()
            }
            articles = newsData.articles
        }
    }

    Row {
        //SidePanel
        SidePanel(onMenuSelected = {
            headerTitle = it
            searchedText = ""
            articles = emptyList()
        }, onNewsSearched = { _searchedText, _headerTitle ->
            searchedText = _searchedText
            headerTitle = _headerTitle
            articles = emptyList()
        })
        //MainContent
        ArticleContent(headerTitle, articles)
    }

}