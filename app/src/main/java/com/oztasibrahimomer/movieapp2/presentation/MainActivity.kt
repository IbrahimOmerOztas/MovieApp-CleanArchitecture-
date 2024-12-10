package com.oztasibrahimomer.movieapp2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.oztasibrahimomer.movieapp2.presentation.movie_detail.view.MovieDetailScreen
import com.oztasibrahimomer.movieapp2.presentation.movies.views.MoviesScreen
import com.oztasibrahimomer.movieapp2.presentation.ui.theme.MovieApp2Theme
import com.oztasibrahimomer.movieapp2.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.MOVIE.route){
                        composable( Screen.MOVIE.route){
                            MoviesScreen(navController)
                        }
                        composable(
                            "${Screen.MOVIEDETAIL.route}/{imdbID}",
                            arguments = listOf(navArgument("imdbID"){ type = NavType.StringType})
                        ){
                            var imdbID = it.arguments?.getString("imdbID") ?: "Bok"
                            imdbID = imdbID.replace("{","").replace("}","")

                            MovieDetailScreen(imdbID)
                        }
                    }

                }
            }
        }
    }
}

