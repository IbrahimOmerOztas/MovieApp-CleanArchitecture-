package com.oztasibrahimomer.movieapp2.presentation.movie_detail.view

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.oztasibrahimomer.movieapp2.presentation.movie_detail.MovieDetailViewModel
import com.oztasibrahimomer.movieapp2.util.Resource

@Composable
fun MovieDetailScreen(
    imdbID:String,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    


    LaunchedEffect(Unit){
        viewModel.getMovieDetail(imdbID)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){


            if(state.isLoading){

                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp,50.dp),
                    color=Color.Blue
                )


            }

            state.movieDetail?.let {

                AsyncImage(
                    model = it.Poster,
                    contentDescription = "",
                    modifier = Modifier
                        .size(250.dp,300.dp)
                        .border(2.dp, color = Color.White, RectangleShape)

                )
                Spacer(modifier = Modifier.height(25.dp))

                Column(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Text(
                        text = it.Title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = it.Actors,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = it.Country,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = it.Year,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(3.dp))


                    Text(
                        text = it.Type,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(3.dp))



                }
            }



        }
    }
}