package com.sample.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.sample.app.adapter.TrailerAdapter
import com.sample.app.api.Client
import com.sample.app.api.Service
import com.sample.app.model.MoviesResponse
import com.sample.app.model.Trailer
import com.sample.app.model.TrailerResponse
import com.sample.app.movie_select.MovieSelectActivity
import com.sample.app.tabs_screens.tabs.TabsActivity
import kotlinx.android.synthetic.main.content_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class DetailActivity : AppCompatActivity() {
    lateinit var nameOfMovie : TextView
    lateinit var plotSynopsis : TextView
    lateinit var userRating : TextView
    lateinit var releaseDate : TextView
    lateinit var popularity : TextView

    private lateinit var imageView : ImageView

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : TrailerAdapter
    private lateinit var trailerList : List<Trailer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolBar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        initCollapsingToolBar()

        imageView = findViewById(R.id.thumbnail_image_header)
        nameOfMovie = findViewById(R.id.title)
        plotSynopsis = findViewById(R.id.plotsysnopsis)
        userRating =  findViewById(R.id.userrating)
        releaseDate =  findViewById(R.id.releasedate)
        popularity = findViewById(R.id.popularityNumb)

        val intentThatStartedThisActivity = intent
        if(intentThatStartedThisActivity.hasExtra("original_title")){
            val thumbnail = intent.extras!!.getString("poster_path")
            val movieName = intent.extras!!.getString("original_title")
            val synopsis = intent.extras!!.getString("overview")
            val rating = intent.extras!!.getString("vote_average")
            val dateOfRelease = intent.extras!!.getString("release_date")
            val popularityNumb = intent.extras!!.getString("popularity")
            println(" ---------------------------------$thumbnail")
            Glide.with(this)
                .load(thumbnail)
                .placeholder(R.drawable.load)
                .into(imageView)

            nameOfMovie.text = movieName
            plotSynopsis.text = synopsis
            userRating.text = rating
            releaseDate.text = dateOfRelease
            popularity.text = popularityNumb
        } else{
            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show()
        }

        similar_movie.setOnClickListener{
            startActivity(Intent(this, TabsActivity::class.java))
        }


//        initViews()
    }

    private fun initCollapsingToolBar(){

        val collapsingToolbarLayout : CollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
        collapsingToolbarLayout.title = " "
        val appBarLayout : AppBarLayout = findViewById(R.id.appBar)
        appBarLayout.setExpanded(true)

        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if(scrollRange == -1){
                    scrollRange = appBarLayout!!.totalScrollRange
                }
                if(scrollRange + verticalOffset == 0){
                    collapsingToolbarLayout.title = getString(R.string.movie_details)
                    isShow = true
                } else if(isShow){
                    collapsingToolbarLayout.title = " "
                    isShow = false
                }
            }
        })

    }

    private fun initViews(){
        trailerList = listOf()
        adapter = TrailerAdapter(this, trailerList)
//        recyclerView = findViewById(R.id.recycler_view1)
        val mLayoutManager : RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        loadJSON()

    }

    private fun loadJSON(){
        val movie_id : Int = intent.extras!!.getInt("id")
        try {
            if(BuildConfig.MOVIE_BOX_API_TOKEN.isEmpty()){
                Toast.makeText(applicationContext, "Please, obtain first API key from ......", Toast.LENGTH_SHORT).show()
                return
            }

            val client = Client()
            var apiService = client.getClient().create(Service::class.java)
            val call : Call<TrailerResponse>
            call = apiService.getMovieTrailer(movie_id, BuildConfig.MOVIE_BOX_API_TOKEN)
            call.enqueue(object : Callback<TrailerResponse> {
                override fun onResponse(call: Call<TrailerResponse>, response: Response<TrailerResponse>) {
                    var trailers : List<Trailer> = response.body()!!.results
                    recyclerView.adapter = TrailerAdapter(applicationContext, trailers)
                    recyclerView.smoothScrollToPosition(0)

                }

                override fun onFailure(call: Call<TrailerResponse>, t: Throwable) {
                    Log.d("Error", t.message)
                    Toast.makeText(this@DetailActivity, "Error Fetching Trailer Data!", Toast.LENGTH_SHORT).show()
                }
            })

        } catch (e : Exception){
            Log.d("Error", e.message)
            Toast.makeText(this@DetailActivity, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }


}