package com.abdulqayoom.dailypulse.articles

data class ArticleState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
