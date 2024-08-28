package com.abdulqayoom.dailypulse.articles

import com.abdulqayoom.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModels: BaseViewModel() {
    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(isLoading = true))
    val articleState: StateFlow<ArticleState> get() = _articleState

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
//    val articles = _articles.asStateFlow()

    init {
        getArticles()
    }

    private val mockArticles = listOf(
        Article(
            title = "Article 1",
            description = "This is the first article",
            date = "2022-01-01",
            imageUrl = "https://dummyimage.com/500x400/ff6699/000"
        ),
        Article(
            title = "Article 1",
            description = "This is the first article",
            date = "2022-01-01",
            imageUrl = "https://dummyimage.com/500x400/ff6699/000"
        ),
        Article(
            title = "Article 1",
            description = "This is the first article",
            date = "2022-01-01",
            imageUrl = "https://dummyimage.com/500x400/ff6699/000"
        ),
    )

    suspend fun fitchArticles(): List<Article> = mockArticles
    private fun getArticles() {
        scope.launch {
            delay(1500)
            _articleState.emit(ArticleState(error =  "Errrrrroorororororor"))

            delay(1500)
            val articles = fitchArticles()
            _articleState.emit(ArticleState(articles =  articles))
        }
    }
}