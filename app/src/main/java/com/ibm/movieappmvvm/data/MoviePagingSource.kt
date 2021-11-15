package com.ibm.movieappmvvm.data

import androidx.paging.PagingSource
import com.ibm.movieappmvvm.api.MovieApi
import retrofit2.HttpException
import java.io.IOException

private const val MOVIE_STARTING_PAGE_INDEX = 1

class MoviePagingSource(
    private val movieApi: MovieApi,
    private val query: String
) : PagingSource<Int, MovieModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val position = params.key ?: MOVIE_STARTING_PAGE_INDEX

        return try {
            val response = movieApi.searchMovies(MovieApi.API_KEY, position, query)
            val movie = response.results

            LoadResult.Page(
                data = movie,
                prevKey = if (position == MOVIE_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (movie.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}