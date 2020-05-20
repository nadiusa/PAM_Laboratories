package com.sample.app.movie_select.movieGenres

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.Surface
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.BuildConfig
import com.sample.app.R
import com.sample.app.adapter.MoviesAdapter
import com.sample.app.api.Client
import com.sample.app.api.Service
import com.sample.app.model.Movie
import com.sample.app.model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class DramaActivity : AppCompatActivity(){


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesAdapter
    private lateinit var movieList: List<Movie>
    val LOG_TAG = MoviesAdapter::class.java.name
    private lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_list_activity)

        initViews()
    }

    private fun initViews(){
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Fetching most rated movies...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        recyclerView = findViewById(R.id.feed_recycler_view)

        movieList = listOf()
        adapter = MoviesAdapter(this, movieList)


        if(getScreenOrientation(this) == "SCREEN_ORIENTATION_PORTRAIT"){
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
        loadJSON()
    }

    private fun loadJSON(){
        try {
            if(BuildConfig.MOVIE_BOX_API_TOKEN.isEmpty()){
                Toast.makeText(applicationContext, "Please, obtain first API key from ......", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
                return
            }

            val client = Client()
            var apiService = client.getClient().create(Service::class.java)
            val call : Call<MoviesResponse>
            call = apiService.getTopRatedMovies(BuildConfig.MOVIE_BOX_API_TOKEN)
            call.enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                    var movies : List<Movie> = response.body()!!.results
                    recyclerView.adapter = MoviesAdapter(applicationContext, movies)
                    recyclerView.smoothScrollToPosition(0)
                    progressDialog.dismiss()
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.d("Error", t.message)
                    Toast.makeText(this@DramaActivity, "Error Fetching Data!", Toast.LENGTH_SHORT).show()
                }
            })

        } catch (e : Exception){
            Log.d("Error", e.message)
            Toast.makeText(this@DramaActivity, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_settings -> return true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getScreenOrientation(context: Context): String {
        val screenOrientation = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.orientation
        when (screenOrientation) {
            Surface.ROTATION_0 -> return "SCREEN_ORIENTATION_PORTRAIT"
            Surface.ROTATION_90 -> return "SCREEN_ORIENTATION_LANDSCAPE"
            Surface.ROTATION_180 -> return "SCREEN_ORIENTATION_REVERSE_PORTRAIT"
            else -> return "SCREEN_ORIENTATION_REVERSE_LANDSCAPE"
        }
    }



}
