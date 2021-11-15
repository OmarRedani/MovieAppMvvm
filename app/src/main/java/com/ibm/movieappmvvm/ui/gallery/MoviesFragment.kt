package com.ibm.movieappmvvm.ui.gallery

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ibm.movieappmvvm.R
import com.ibm.movieappmvvm.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private val viewModel by viewModels<MovieViewModel>()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMoviesBinding.bind(view)

        val adapter = MovieAdapter()

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter.withLoadStateFooter(
                footer = MovieLoadStateAdapter { adapter.retry() }
            )
        }

        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_movies, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_desc -> {
                filterBy("release_date.desc")
                true
            }
            R.id.action_sort_asc -> {
                filterBy("release_date.asc")
                true
            }
            R.id.action_vote_desc -> {
                filterBy("vote_average.desc")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun filterBy(query:String){
        viewModel.searchMovies(query)
        binding.recyclerView.scrollToPosition(0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}