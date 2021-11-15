package com.ibm.movieappmvvm.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.ibm.movieappmvvm.data.MovieRepository

class MovieViewModel @ViewModelInject constructor(
    private val repository: MovieRepository
) : ViewModel() {
}