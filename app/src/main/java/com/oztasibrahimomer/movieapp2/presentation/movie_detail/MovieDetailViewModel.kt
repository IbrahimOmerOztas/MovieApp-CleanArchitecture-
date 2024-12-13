package com.oztasibrahimomer.movieapp2.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oztasibrahimomer.movieapp2.domain.model.MovieDetail
import com.oztasibrahimomer.movieapp2.domain.use_case.movie_detail_use_case.GetMovieDetailUseCase
import com.oztasibrahimomer.movieapp2.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: GetMovieDetailUseCase):ViewModel() {


   /* private val _state = MutableStateFlow<DetailState>(DetailState())
    val state:StateFlow<DetailState> = _state

    */

    private val _state = mutableStateOf(DetailState())
    val state :State<DetailState> = _state


    private var job: Job? = null

    init {

        getMovieDetail(_state.value.imdbId)

    }




    fun getMovieDetail(imdbId:String){

         movieDetailUseCase.executeMovieDetail(imdbId).onEach {

            when(it){
                is Resource.Error -> {

                   _state.value = DetailState(imdbId=imdbId,error=it.message ?:"not data found")

                }
                is Resource.Loading -> {
                    _state.value = DetailState(imdbId=imdbId,isLoading = true)
                }
                is Resource.Success -> {

                    _state.value = DetailState(imdbId=imdbId,movieDetail = it.data!!)
                }
            }


        }.launchIn(viewModelScope)


    }





}