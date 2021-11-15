package com.ibm.movieappmvvm.data

import com.ibm.movieappmvvm.api.MovieApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApi: MovieApi) {
}