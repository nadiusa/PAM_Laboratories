package com.sample.app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.app.DetailActivity
import com.sample.app.R
import com.sample.app.model.Movie


class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.FeedItemViewHolder> {

    var mContext :Context
    private var movieList : List<Movie>
    var imageBaseUrl = "https://image.tmdb.org/t/p/w500"
    constructor(mContext : Context, movieList : List<Movie> ){
        this.mContext = mContext
        this.movieList = movieList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.FeedItemViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_card, parent, false)
        return FeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.FeedItemViewHolder, position: Int) {
        holder.title.text = movieList[position].original_title
        val vote  = movieList[position].vote_average.toString()
        holder.userrating.text = vote

        Glide.with(mContext)
            .load(imageBaseUrl + movieList[position].poster_path)
            .placeholder(R.drawable.load)
            .into(holder.thumbnail)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class FeedItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title : TextView
        var userrating : TextView
        var thumbnail : ImageView


        init {
            title = view.findViewById(R.id.title)
            userrating = view.findViewById(R.id.userrating)
            thumbnail = view.findViewById(R.id.thumbnail)
            view.setOnClickListener { v ->
                val pos = adapterPosition
                if(pos != RecyclerView.NO_POSITION ){
                    val clickedDataItem : Movie = movieList[pos]
                    val intent : Intent = Intent(mContext, DetailActivity::class.java)
                    intent.putExtra("poster_path", imageBaseUrl + movieList[pos].poster_path)
                    intent.putExtra("overview", movieList[pos].overview)
                    intent.putExtra("release_date", movieList[pos].release_date)
                    intent.putExtra("original_title", movieList[pos].original_title)
                    intent.putExtra("original_language", movieList[pos].original_language)
                    intent.putExtra("vote_average",  movieList[pos].vote_average.toString())
                    intent.putExtra("popularity", movieList[pos].popularity.toString())
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    mContext.startActivity(intent)
                    Toast.makeText(v.context, "You clicked   ${clickedDataItem.title}", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
