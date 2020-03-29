package com.example.themovie.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovie.DetailActivity
import com.example.themovie.R
import com.example.themovie.model.Movie
import kotlinx.android.synthetic.main.movie_card.view.*
import java.security.AccessControlContext

 class MovieAdapter(
    var context: Context,
    var moviesList: List<Movie>? = null
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
     override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
         val view = LayoutInflater.from(p0.context).inflate(R.layout.movie_card, p0, false)
         return MovieViewHolder(view)
     }
     override fun getItemCount(): Int {
         return moviesList?.size ?:0
     }

     override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
         holder.bind(moviesList?.get(position))

     }

    inner class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: Movie?) {
            val  title = view.findViewById<TextView>(R.id.tv_title)
            val description = view.findViewById<TextView>(R.id.tv_des)
            val date = view.findViewById<TextView>(R.id.tv_date)
            val commnetsCount = view.findViewById<TextView>(R.id.tv_comment)
            val poster = view.findViewById<ImageView>(R.id.poster)

            title.text=post?.original_title
            description.text=post?.overview
            date.text=post?.release_date
            Glide.with(context)
                .load(post?.getPosterPath())
                .into(poster)
            view.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("original_title", post?.original_title)
                intent.putExtra("poster_path", post?.poster_path)
                intent.putExtra("overview", post?.overview)
                intent.putExtra("vote_average", (post?.vote_average).toString())
                intent.putExtra("relase_date", post?.release_date)
                context.startActivity(intent)
            }
        }

    }



}