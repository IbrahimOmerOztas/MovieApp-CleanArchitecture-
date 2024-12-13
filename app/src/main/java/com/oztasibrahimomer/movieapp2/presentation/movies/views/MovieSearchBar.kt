package com.oztasibrahimomer.movieapp2.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    modifier: Modifier,
    hint:String="",
    onSearch : (String)-> Unit ={}
) {

    var text by remember{ mutableStateOf("")}
    var isHintDisplayed by remember{ mutableStateOf(hint!="")}
    
    Box(modifier = modifier.clickable {  }){
        Spacer(modifier = Modifier.height(10.dp))
        
        TextField(
            value = text ,
            onValueChange = {text = it},
            maxLines = 1,
            trailingIcon = {
                           IconButton(onClick = {
                               onSearch(text)
                           }) {
                               Icon(imageVector = Icons.Default.Search, contentDescription = "")
                           }
            },
            textStyle = TextStyle(color=Color.Black),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent

            ),
            shape= RoundedCornerShape(12.dp),
            modifier = modifier
                .shadow(5.dp, RectangleShape)
                .height(60.dp)
                .padding(horizontal = 10.dp)
                .onFocusChanged {

                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                }


        )
        
        if (isHintDisplayed){
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 23.dp)
            )
        }
    }




}
