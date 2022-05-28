package com.prathamesh.imdb.datastores.remotestores

import androidx.paging.PagingSource
import com.prathamesh.imdb.models.Movie
import okio.IOException
import retrofit2.HttpException

class MoviesPagingSource(private val remoteStore: MovieRemoteStore): PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val response = remoteStore.getMovies(page)
            LoadResult.Page(
                response, prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {

        private const val DEFAULT_PAGE_INDEX = 1
    }
}