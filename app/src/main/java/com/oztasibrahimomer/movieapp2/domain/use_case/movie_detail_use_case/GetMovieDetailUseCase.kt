package com.oztasibrahimomer.movieapp2.domain.use_case.movie_detail_use_case

import com.oztasibrahimomer.movieapp2.data.remote.DTO.toMovieDetail
import com.oztasibrahimomer.movieapp2.domain.model.MovieDetail
import com.oztasibrahimomer.movieapp2.domain.repository.MovieRepository
import com.oztasibrahimomer.movieapp2.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {


    fun executeMovieDetail(imdbID:String) : Flow<Resource<MovieDetail>> = flow{

        try{
            emit(Resource.Loading())

            val movieDetailDto = repository.getMovieDetail(imdbId = imdbID)

            if(movieDetailDto.Response=="True"){
                emit(Resource.Success(movieDetailDto.toMovieDetail()))

            }
            else{
                emit(Resource.Error(message = "Not found Data"))
            }



        }
        catch (e:Exception){
            emit(Resource.Error(e.message ?: "not found data"))
        }




    }
}