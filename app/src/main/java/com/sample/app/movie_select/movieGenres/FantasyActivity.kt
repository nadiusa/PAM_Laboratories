package com.sample.app.movie_select.movieGenres

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.model.Movie

class FantasyActivity : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fantasy_list_activity)

//        // Create Recycler view layout manager, for simple lists use Linear layout
//        viewManager = LinearLayoutManager(this)
//
//        // Create sample data set of 30 dummy elements
//        viewAdapter = FeedRecyclerViewAdapter(Array(30) {
//            Movie(
//                "Fantasy film here",
//                "Some description",
//                "https://upload.wikimedia.org/wikipedia/en/1/10/Fantasy_Records_2018_logo.png"
//            )
//        })
//
//        // Find recycler view in hierarchy of elements and set layout manager and adapter
//        recyclerView = findViewById<RecyclerView>(R.id.feed_recycler_view).apply {
//            // use this setting to improve performance if you know that changes
//            // in content do not change the layout size of the RecyclerView
//
//            // use a linear layout manager
//            layoutManager = viewManager
//
//            // specify an viewAdapter (see also next example)
//            adapter = viewAdapter
//        }
    }
}
