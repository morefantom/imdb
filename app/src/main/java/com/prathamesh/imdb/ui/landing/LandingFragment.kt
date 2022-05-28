package com.prathamesh.imdb.ui.landing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prathamesh.imdb.R
import com.prathamesh.imdb.databinding.LandingFragmentBinding

class LandingFragment : Fragment() {

    private lateinit var viewModel: LandingViewModel
    private lateinit var binding: LandingFragmentBinding

    companion object {
        fun newInstance() = LandingFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LandingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LandingViewModel::class.java]
    }
}