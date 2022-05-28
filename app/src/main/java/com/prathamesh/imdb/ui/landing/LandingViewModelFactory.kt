package com.prathamesh.imdb.ui.landing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prathamesh.imdb.datastores.MovieRepository
import java.lang.IllegalArgumentException

class LandingViewModelFactory(
    val repository: MovieRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LandingViewModel::class.java)) {
            return LandingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}