package com.ibm.movieappmvvm.api

import com.ibm.movieappmvvm.data.MovieModel

data class MovieResponse(
    val results: List<MovieModel>
)
