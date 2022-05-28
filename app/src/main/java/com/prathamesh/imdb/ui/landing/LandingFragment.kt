package com.prathamesh.imdb.ui.landing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.prathamesh.imdb.databinding.LandingFragmentBinding
import com.prathamesh.imdb.datastores.MovieRepository
import com.prathamesh.imdb.datastores.MovieRepositoryImpl
import com.prathamesh.imdb.datastores.remotestores.MovieRemoteStoreImpl
import com.prathamesh.imdb.datastores.remotestores.MoviesPagingSource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class LandingFragment : Fragment() {

    private lateinit var viewModel: LandingViewModel
    private lateinit var binding: LandingFragmentBinding

    private val movieAdapter: MovieAdapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LandingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = LandingViewModelFactory(composeRepository())
        viewModel = ViewModelProvider(this, factory)[LandingViewModel::class.java]

        binding.rvMovieList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = movieAdapter
        }

        lifecycleScope.launch {
            viewModel.fetchMovies().collectLatest {
                movieAdapter.submitData(it)
            }
        }
    }

    private fun composeRepository() = MovieRepositoryImpl(MoviesPagingSource(MovieRemoteStoreImpl()))
}