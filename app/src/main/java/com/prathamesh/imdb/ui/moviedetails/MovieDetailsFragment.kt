package com.prathamesh.imdb.ui.moviedetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prathamesh.imdb.R
import com.prathamesh.imdb.databinding.MovieDetailsFragmentBinding

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: MovieDetailsFragmentBinding
    private lateinit var viewModel: MovieDetailsViewModel

    companion object {
        fun newInstance() = MovieDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }

}