package com.sample.app.movie_select.movieGenres

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.model.Movie

class ComedyActivity : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comedy_list_activity)

        // Create Recycler view layout manager, for simple lists use Linear layout
//        viewManager = LinearLayoutManager(this)
//
//        // Create sample data set of 30 dummy elements
//        viewAdapter = FeedRecyclerViewAdapter(Array(30) {
//            Movie(
//                "Comedy film here",
//                "Some description",
//                "https://cdn.clipart.email/f09bb6c89d553f4f1917b46ef9685081_comedy-movie-clipart_436-470.jpeg"
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
