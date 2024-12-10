package com.oztasibrahimomer.movieapp2.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oztasibrahimomer.movieapp2.domain.use_case.movie_use_case.GetMoviesUseCase
import com.oztasibrahimomer.movieapp2.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase :GetMoviesUseCase
) : ViewModel(){


    private val _state = mutableStateOf(MoviesState())
    val state:State<MoviesState> = _state


    private var job: Job? = null

    init {
        getMovies("naruto")
    }


    private fun getMovies(search:String) {

        job?.cancel()


        job = getMoviesUseCase.executeGetMovies(search = search).onEach {
            when(it){
                is Resource.Error -> {
                    _state.value = MoviesState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MoviesState(movieList = it.data ?: emptyList())
                }
            }

        }.launchIn(viewModelScope)

    }

    fun onEvent(event:MoviesEvent) {

        when(event){
            is MoviesEvent.Search -> {
                getMovies(event.search)
            }
        }
    }


}