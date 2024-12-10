package com.oztasibrahimomer.movieapp2.domain.use_case.movie_use_case

import com.oztasibrahimomer.movieapp2.data.remote.DTO.toMovies
import com.oztasibrahimomer.movieapp2.domain.model.Movie
import com.oztasibrahimomer.movieapp2.domain.repository.MovieRepository
import com.oztasibrahimomer.movieapp2.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {



    fun executeGetMovies(search:String) : Flow<Resource<List<Movie>>> = flow {

        try {
            emit(Resource.Loading())
            val moviesDto = repository.getMovies(search = search)

            if (moviesDto.Response.equals("True")){
                // dogru sorgu ile verler aliniyor demek

                emit(Resource.Success(moviesDto.toMovies()))

            }
            else{

                // yanlis sorgu ile verler alinamiyor!!

                emit(Resource.Error("Not found data!!"))


            }

        }
        catch (e:Exception){

            emit(Resource.Error(e.message ?: "Exception vaaar"))
        }

    }
}