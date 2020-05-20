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
import com.sample.app.model.Genre
import com.sample.app.model.Movie
import com.sample.app.movie_select.MovieSelectActivity


class GenresAdapter : RecyclerView.Adapter<GenresAdapter.FeedItemViewHolder> {

    var mContext :Context
    private var genresList : List<Genre>

    constructor(mContext : Context, genresList : List<Genre> ){
        this.mContext = mContext
        this.genresList = genresList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenresAdapter.FeedItemViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.genre_content_layout, parent, false)
        return FeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenresAdapter.FeedItemViewHolder, position: Int) {
        holder.genreName.text = genresList[position].name

    }

    override fun getItemCount(): Int {
        return genresList.size
    }

    inner class FeedItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var genreName : TextView

        init {
            genreName = view.findViewById(R.id.genre)
            view.setOnClickListener { v ->
                val pos = adapterPosition
                if(pos != RecyclerView.NO_POSITION ){
                    val clickedDataItem : Genre = genresList[pos]
                    val intent : Intent = Intent(mContext, MovieSelectActivity::class.java)
                    intent.putExtra("name",  genresList[pos].name)
                    intent.putExtra("id",  genresList[pos].id)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    mContext.startActivity(intent)
                    Toast.makeText(v.context, "You clicked   ${clickedDataItem.name}", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
