package com.sample.app.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import com.sample.app.model.Trailer
import com.sample.app.movie_select.MovieSelectActivity


class TrailerAdapter : RecyclerView.Adapter<TrailerAdapter.FeedItemViewHolder> {

    var mContext :Context
    private var trailerList : List<Trailer>

    constructor(mContext : Context, trailerList : List<Trailer> ){
        this.mContext = mContext
        this.trailerList = trailerList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrailerAdapter.FeedItemViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.trailer_card, parent, false)
        return FeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailerAdapter.FeedItemViewHolder, position: Int) {
        holder.title.text = trailerList[position].name

    }

    override fun getItemCount(): Int {
        return trailerList.size
    }

    inner class FeedItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title : TextView
        var thumbnail :ImageView

        init {
            title = view.findViewById(R.id.title)
            thumbnail = view.findViewById(R.id.thumbnail)
            view.setOnClickListener { v ->
                val pos = adapterPosition
                if(pos != RecyclerView.NO_POSITION ){
                    val clickedDataItem : Trailer = trailerList[pos]
                    val videoId : String = trailerList[pos].key
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId"))
                    intent.putExtra("video_id",  videoId)
                    mContext.startActivity(intent)
                    Toast.makeText(v.context, "You clicked   ${clickedDataItem.name}", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
