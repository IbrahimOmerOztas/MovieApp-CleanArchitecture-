package com.oztasibrahimomer.movieapp2.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.oztasibrahimomer.movieapp2.domain.model.Movie

@Composable
fun MovieListRow(
    movie:Movie,
    onItemClick : (Movie)-> Unit

) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(movie)
            }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){



        AsyncImage(
            model = movie.Poster,
            contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp, 220.dp)
                .clip(RectangleShape)

        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(text = movie.Title, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center,color=Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = movie.Year, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center,color=Color.White)



        }

        



    }


}