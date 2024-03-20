package com.tao.movieretrodemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tao.movieretrodemo.poulardata.Result

class MoviesAdapter(private val movies: List<Result>) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val movieTitle: TextView = view.findViewById(R.id.movie_title)
        private val movieRating: TextView = view.findViewById(R.id.movie_rating)
        private val moviePoster: ImageView = view.findViewById(R.id.movie_poster)

        fun bind(movie: Result) {
            movieTitle.text = movie.title
            movieRating.text = "Rating: ${movie.vote_average}/10"
            Picasso.get().load(Constants.IMAGE_ENDPOINT + movie.poster_path)
                .into(moviePoster)
        }
    }
}
