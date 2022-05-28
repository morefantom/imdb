package com.prathamesh.imdb.datastores.remotestores

import com.prathamesh.imdb.BuildConfig
import com.prathamesh.imdb.models.Movie

interface MovieRemoteStore {

    suspend fun getMovies(page: Int): List<Movie>
}

class MovieRemoteStoreImpl: MovieRemoteStore {

    private val movieService = RetrofitBuilder.buildGeneric(
        MovieService::class.java,
        BuildConfig.THE_MOVIE_DB_BASE_URL
    )

    override suspend fun getMovies(page: Int): List<Movie> {
        val response = movieService.getPopular(
            apiKey = BuildConfig.THE_MOVIE_DB_API_KEY,
            lang = "en-US",
            page = page
        )
        return response
            .results
            .map { Movie(it) }
    }
}