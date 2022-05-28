package com.prathamesh.imdb.models

import com.prathamesh.imdb.datastores.remotestores.response.MovieResponse

data class Movie(
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
) {
    constructor(movieResponse: MovieResponse): this(
        originalTitle = movieResponse.originalTitle,
        overview = movieResponse.overview,
        popularity = movieResponse.popularity,
        posterPath = movieResponse.posterPath,
        releaseDate = movieResponse.releaseDate,
        title = movieResponse.title
    )
}
