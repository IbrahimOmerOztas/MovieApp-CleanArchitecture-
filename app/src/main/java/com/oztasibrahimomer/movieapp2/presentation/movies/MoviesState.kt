package com.oztasibrahimomer.movieapp2.presentation.movies

import com.oztasibrahimomer.movieapp2.domain.model.Movie

data class MoviesState(

    val isLoading:Boolean=false,
    val movieList:List<Movie> = emptyList(),
    val error:String = "",
    val search: String = "Batman"
)
