package com.oztasibrahimomer.movieapp2.presentation.movies

sealed class MoviesEvent{
    data class Search(val search:String):MoviesEvent()
}
