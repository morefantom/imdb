package com.prathamesh.imdb.ui.landing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.prathamesh.imdb.datastores.MovieRepository
import com.prathamesh.imdb.models.Movie
import kotlinx.coroutines.flow.Flow

class LandingViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun fetchMovies(): Flow<PagingData<Movie>> {
        return repository.letMoviesFlow()
            .cachedIn(viewModelScope)
    }
}