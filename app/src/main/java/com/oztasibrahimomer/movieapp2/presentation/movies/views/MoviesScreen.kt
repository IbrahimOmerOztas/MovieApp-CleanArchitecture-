package com.oztasibrahimomer.movieapp2.presentation.movies.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.oztasibrahimomer.movieapp2.presentation.movies.MoviesEvent
import com.oztasibrahimomer.movieapp2.presentation.movies.MoviesViewModel
import com.oztasibrahimomer.movieapp2.util.Screen


@Composable
fun MoviesScreen(

    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel()

) {
    val context= LocalContext.current

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){

            MovieSearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                hint = "Batman",
                onSearch = {
                    viewModel.onEvent(MoviesEvent.Search(it))
                })

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                items(state.movieList){movie->

                    MovieListRow(movie = movie, onItemClick = {
                        navController.navigate(Screen.MOVIEDETAIL.route+"/{${it.imdbID}}")
                        Toast.makeText(context,it.imdbID,Toast.LENGTH_SHORT).show()
                    })


                }


            }



        }
    }

}