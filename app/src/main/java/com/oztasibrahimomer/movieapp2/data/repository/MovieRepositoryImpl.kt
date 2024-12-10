package com.oztasibrahimomer.movieapp2.data.repository

import com.oztasibrahimomer.movieapp2.data.remote.DTO.MovieDetailDTO
import com.oztasibrahimomer.movieapp2.data.remote.DTO.MoviesDTO
import com.oztasibrahimomer.movieapp2.data.remote.service.MovieAPI
import com.oztasibrahimomer.movieapp2.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api:MovieAPI) : MovieRepository {

    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(search=search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDTO {
        return api.getMovieDetail(imdbId = imdbId)
    }
}