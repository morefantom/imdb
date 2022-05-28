package com.prathamesh.imdb.ui.landing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.prathamesh.imdb.databinding.RowMovieBinding
import com.prathamesh.imdb.models.Movie

class MovieAdapter :
    PagingDataAdapter<Movie, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? MovieViewHolder)?.bind(getItem(position) ?: return)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RowMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieViewHolder(binding)
    }

    class MovieViewHolder(private val binding: RowMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                tvMovieTitle.text = movie.title
                tvMovieDescription.text = movie.overview
            }
        }

    }


}