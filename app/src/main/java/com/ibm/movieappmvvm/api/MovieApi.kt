package com.ibm.movieappmvvm.api

import com.ibm.movieappmvvm.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = BuildConfig.ACCESS_KEY
        const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/original"
    }

    @GET("discover/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String
    ): MovieResponse
}