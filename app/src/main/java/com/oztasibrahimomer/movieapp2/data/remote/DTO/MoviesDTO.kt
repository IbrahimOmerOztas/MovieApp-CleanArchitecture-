package com.oztasibrahimomer.movieapp2.data.remote.DTO

import com.oztasibrahimomer.movieapp2.domain.model.Movie

data class MoviesDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDTO.toMovies():List<Movie>{
    return Search.map { Movie(it.Poster,it.Title,it.Year,it.imdbID) }

}
