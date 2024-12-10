package com.oztasibrahimomer.movieapp2.data.remote.service

import com.oztasibrahimomer.movieapp2.data.remote.DTO.MovieDetailDTO
import com.oztasibrahimomer.movieapp2.data.remote.DTO.MoviesDTO
import com.oztasibrahimomer.movieapp2.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //https://omdbapi.com/?apikey=8c3cd8e2&i=tt2975590 -> movie detail

    //https://omdbapi.com/?apikey=8c3cd8e2&s=batman%20begins -> movies

    @GET(".")
    suspend fun getMovies(

        @Query("s") search:String,
        @Query("apikey")apiKey:String = API_KEY
    ):MoviesDTO


    @GET(".")
    suspend fun getMovieDetail(

        @Query("i") imdbId:String,
        @Query("apikey")apiKey:String = API_KEY
    ):MovieDetailDTO

}