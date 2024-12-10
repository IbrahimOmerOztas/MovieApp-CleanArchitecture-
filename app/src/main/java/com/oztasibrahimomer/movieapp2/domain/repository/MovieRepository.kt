package com.oztasibrahimomer.movieapp2.domain.repository

import com.oztasibrahimomer.movieapp2.data.remote.DTO.MovieDetailDTO
import com.oztasibrahimomer.movieapp2.data.remote.DTO.MoviesDTO

interface MovieRepository {

    suspend fun getMovies(search:String):MoviesDTO
    suspend fun getMovieDetail(imdbId:String): MovieDetailDTO
}