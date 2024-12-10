package com.oztasibrahimomer.movieapp2.presentation.movie_detail

import com.oztasibrahimomer.movieapp2.domain.model.MovieDetail

data class DetailState(

    val imdbId:String="",
    val isLoading:Boolean=false,
    val error:String="",
    val movieDetail:MovieDetail?=null


)