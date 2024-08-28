package com.abdulqayoom.dailypulse.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.abdulqayoom.dailypulse.articles.Article
import com.abdulqayoom.dailypulse.articles.ArticlesViewModels

@Composable
fun ArticlesScreen (articlesViewModels: ArticlesViewModels) {
    val state = articlesViewModels.articleState.collectAsState()

    Column {
        Toolbar()
        //ContentView()
        if (state.value.isLoading) {
            LoadingView()
        }
        else if (state.value.error != null) {
            ErrorView(state.value.error)
        }
        else if (state.value.articles.isNotEmpty()) {
            ContentView(state.value.articles)
        }
    }

}

@Composable
fun ContentView(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp),) {
        items(articles) { article ->
            ArticleItem(article = article)
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )  {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.description,
//            style = TextStyle(
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold
//            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier
                .align(Alignment.End)
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }

}

@Composable
fun ErrorView(error: String? = null) {
    Box (
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = error ?: "Something went wrong",
            style = TextStyle(fontSize = 18.sp)
        )
    }
}

@Composable
fun LoadingView() {
    Box (
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar() {
    TopAppBar(title = { Text(text = "Articles") })
}

