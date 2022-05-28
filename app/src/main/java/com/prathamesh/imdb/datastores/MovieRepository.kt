package com.prathamesh.imdb.datastores

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.prathamesh.imdb.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun letMoviesFlow(): Flow<PagingData<Movie>>
}

class MovieRepositoryImpl(
    private val source: PagingSource<Int, Movie>
): MovieRepository {

    override fun letMoviesFlow(): Flow<PagingData<Movie>> {
        return Pager(
            config = getDefaultPageConfig(),
            pagingSourceFactory = { source }
        ).flow
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }

    companion object {

        private const val DEFAULT_PAGE_SIZE = 20
    }
}