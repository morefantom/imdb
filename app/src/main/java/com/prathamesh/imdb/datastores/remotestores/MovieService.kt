package com.prathamesh.imdb.datastores.remotestores

import com.prathamesh.imdb.datastores.remotestores.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("page") page: Int,
    ): MoviesResponse
}