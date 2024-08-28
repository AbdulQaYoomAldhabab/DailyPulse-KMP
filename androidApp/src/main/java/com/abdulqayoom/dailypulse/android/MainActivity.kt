package com.abdulqayoom.dailypulse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdulqayoom.dailypulse.Platform
import com.abdulqayoom.dailypulse.android.screens.AboutScreen
import com.abdulqayoom.dailypulse.android.screens.ArticlesScreen
import com.abdulqayoom.dailypulse.articles.ArticlesViewModels

class MainActivity : ComponentActivity() {
    val articlesViewModels : ArticlesViewModels by lazy { ArticlesViewModels() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Platform().logSystemInfo()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticlesScreen(articlesViewModels = articlesViewModels)
                }
            }
        }
    }
}



@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        AboutScreen()
//        ArticlesScreen(articlesViewModels = articlesViewModels)
    }
}
